package org.openfact.representations.info;

import java.util.List;
import java.util.Map;


public class ServerInfoRepresentation {

    private SystemInfoRepresentation systemInfo;
    private MemoryInfoRepresentation memoryInfo;

    private Map<String, List<ThemeInfoRepresentation>> themes;

    private List<Map<String, String>> socialProviders;
    private List<Map<String, String>> identityProviders;
    private List<Map<String, String>> clientImporters;

    private Map<String, SpiInfoRepresentation> providers;
   
    private Map<String, List<String>> enums;

    public SystemInfoRepresentation getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfoRepresentation systemInfo) {
        this.systemInfo = systemInfo;
    }

    public MemoryInfoRepresentation getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(MemoryInfoRepresentation memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public Map<String, List<ThemeInfoRepresentation>> getThemes() {
        return themes;
    }

    public void setThemes(Map<String, List<ThemeInfoRepresentation>> themes) {
        this.themes = themes;
    }

    public List<Map<String, String>> getSocialProviders() {
        return socialProviders;
    }

    public void setSocialProviders(List<Map<String, String>> socialProviders) {
        this.socialProviders = socialProviders;
    }

    public List<Map<String, String>> getIdentityProviders() {
        return identityProviders;
    }

    public void setIdentityProviders(List<Map<String, String>> identityProviders) {
        this.identityProviders = identityProviders;
    }

    public List<Map<String, String>> getClientImporters() {
        return clientImporters;
    }

    public void setClientImporters(List<Map<String, String>> clientImporters) {
        this.clientImporters = clientImporters;
    }

    public Map<String, SpiInfoRepresentation> getProviders() {
        return providers;
    }

    public void setProviders(Map<String, SpiInfoRepresentation> providers) {
        this.providers = providers;
    }

    /*public Map<String, List<ProtocolMapperTypeRepresentation>> getProtocolMapperTypes() {
        return protocolMapperTypes;
    }

    public void setProtocolMapperTypes(Map<String, List<ProtocolMapperTypeRepresentation>> protocolMapperTypes) {
        this.protocolMapperTypes = protocolMapperTypes;
    }

    public Map<String, List<ProtocolMapperRepresentation>> getBuiltinProtocolMappers() {
        return builtinProtocolMappers;
    }

    public void setBuiltinProtocolMappers(Map<String, List<ProtocolMapperRepresentation>> builtinProtocolMappers) {
        this.builtinProtocolMappers = builtinProtocolMappers;
    }*/

    public Map<String, List<String>> getEnums() {
        return enums;
    }

    public void setEnums(Map<String, List<String>> enums) {
        this.enums = enums;
    }

    /*public Map<String, List<ClientInstallationRepresentation>> getClientInstallations() {
        return clientInstallations;
    }

    public void setClientInstallations(Map<String, List<ClientInstallationRepresentation>> clientInstallations) {
        this.clientInstallations = clientInstallations;
    }*/
}
