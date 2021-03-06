package org.openfact.authentication;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.services.managers.OrganizationManager;

public class TestClientAuthenticatorProvider implements ClientAuthenticatorProvider {

    protected OpenfactSession session;

    @Context
    SecurityContext sc;
    
    public TestClientAuthenticatorProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public OrganizationModel getOrganization(HttpHeaders headers, HttpServletRequest request) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        return organizationManager.getOpenfactAdminstrationOrganization();
    }

    @Override
    public UserModel getUser(HttpHeaders headers, HttpServletRequest request) {
        return new UserModel() {

            @Override
            public String getUsername() {
                return "test";
            }

            @Override
            public String getFullName() {
                return "test";
            }

            @Override
            public String getEmail() {
                return null;
            }
        };
    }

}
