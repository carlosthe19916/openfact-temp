package org.openfact.email;

import org.openfact.events.Event;
import org.openfact.models.OrganizationModel;
import org.openfact.models.InvoiceModel;
import org.openfact.provider.Provider;


public interface EmailTemplateProvider extends Provider {

    String IDENTITY_PROVIDER_BROKER_CONTEXT = "identityProviderBrokerCtx";

    public EmailTemplateProvider setOrganization(OrganizationModel organization);

    public EmailTemplateProvider setInvoice(InvoiceModel invoice);

    public EmailTemplateProvider setAttribute(String name, Object value);

    public void sendEvent(Event event) throws EmailException;

    /**
     * Reset password sent from forgot password link on login
     *
     * @param link
     * @param expirationInMinutes
     * @throws EmailException
     */
    public void sendPasswordReset(String link, long expirationInMinutes) throws EmailException;

    /**
     * Send to confirm that user wants to link his account with identity broker link
     */
    void sendConfirmIdentityBrokerLink(String link, long expirationInMinutes) throws EmailException;

    /**
     * Change password email requested by admin
     *
     * @param link
     * @param expirationInMinutes
     * @throws EmailException
     */
    public void sendExecuteActions(String link, long expirationInMinutes) throws EmailException;

    public void sendVerifyEmail(String link, long expirationInMinutes) throws EmailException;

}
