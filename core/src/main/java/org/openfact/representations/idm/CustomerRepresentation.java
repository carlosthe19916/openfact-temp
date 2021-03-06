package org.openfact.representations.idm;

public class CustomerRepresentation {

    private String registrationName;
    private String assignedIdentificationId;
    private String additionalIdentificationId;
    private String email;

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getAssignedIdentificationId() {
        return assignedIdentificationId;
    }

    public void setAssignedIdentificationId(String assignedIdentificationId) {
        this.assignedIdentificationId = assignedIdentificationId;
    }

    public String getAdditionalIdentificationId() {
        return additionalIdentificationId;
    }

    public void setAdditionalIdentificationId(String additionalIdentificationId) {
        this.additionalIdentificationId = additionalIdentificationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
