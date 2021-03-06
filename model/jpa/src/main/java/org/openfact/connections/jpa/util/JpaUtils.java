package org.openfact.connections.jpa.util;

import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.jpa.boot.internal.ParsedPersistenceXmlDescriptor;
import org.hibernate.jpa.boot.internal.PersistenceXmlParser;
import org.hibernate.jpa.boot.spi.Bootstrap;
import org.openfact.connections.jpa.entityprovider.JpaEntityProvider;
import org.openfact.connections.jpa.entityprovider.ProxyClassLoader;
import org.openfact.models.OpenfactSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitTransactionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaUtils {

    public static final String HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema";

    public static String getTableNameForNativeQuery(String tableName, EntityManager em) {
        String schema = (String) em.getEntityManagerFactory().getProperties().get(HIBERNATE_DEFAULT_SCHEMA);
        return (schema==null) ? tableName : schema + "." + tableName;
    }

    public static EntityManagerFactory createEntityManagerFactory(OpenfactSession session, String unitName, Map<String, Object> properties, ClassLoader classLoader) {
        PersistenceXmlParser parser = new PersistenceXmlParser(new ClassLoaderServiceImpl(classLoader), PersistenceUnitTransactionType.RESOURCE_LOCAL);
        List<ParsedPersistenceXmlDescriptor> persistenceUnits = parser.doResolve(properties);
        for (ParsedPersistenceXmlDescriptor persistenceUnit : persistenceUnits) {
            if (persistenceUnit.getName().equals(unitName)) {
                List<Class<?>> providedEntities = getProvidedEntities(session);
                for (Class<?> entityClass : providedEntities) {
                    // Add all extra entity classes to the persistence unit.
                    persistenceUnit.addClasses(entityClass.getName());
                }
                // Now build the entity manager factory, supplying a proxy classloader, so Hibernate will be able
                // to find and load the extra provided entities. Set the provided classloader as parent classloader.
                return Bootstrap.getEntityManagerFactoryBuilder(persistenceUnit, properties,
                        new ProxyClassLoader(providedEntities, classLoader)).build();
            }
        }
        throw new RuntimeException("Persistence unit '" + unitName + "' not found");
    }

    /**
     * Get a list of all provided entities by looping over all configured entity providers.
     * 
     * @param session the openfact session
     * @return a list of all provided entities (can be an empty list)
     */
    public static List<Class<?>> getProvidedEntities(OpenfactSession session) {
        List<Class<?>> providedEntityClasses = new ArrayList<>();
        // Get all configured entity providers.
        Set<JpaEntityProvider> entityProviders = session.getAllProviders(JpaEntityProvider.class);
        // For every provider, add all entity classes to the list.
        for (JpaEntityProvider entityProvider : entityProviders) {
            providedEntityClasses.addAll(entityProvider.getEntities());
        }
        return providedEntityClasses;
    }

    /**
     * Get the name of custom table for liquibase updates for give ID of JpaEntityProvider
     * @param jpaEntityProviderFactoryId
     * @return table name
     */
    public static String getCustomChangelogTableName(String jpaEntityProviderFactoryId) {
        String upperCased = jpaEntityProviderFactoryId.toUpperCase();
        upperCased = upperCased.replaceAll("-", "_");
        upperCased = upperCased.replaceAll("[^A-Z_]", "");
        return "DATABASECHANGELOG_" + upperCased.substring(0, Math.min(10, upperCased.length()));
    }

}
