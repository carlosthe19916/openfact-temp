package org.openfact.models;

/**
 * @author carlosthe19916@sistcoop.com
 */

public interface OrganizationSnapshotModel {

    String getId();

    String getAssignedIdentificationId();

    void setAssignedIdentificationId(String assignedIdentificationId);

    DocumentSnapshotModel getAdditionalAccountId();

    void setAdditionalAccountId(String documentName, String documentId);

    String getSupplierName();

    void setSuppliername(String supplierName);

    String getRegistrationName();

    void setRegistrationName(String registrationName);

    String getAddress();

    void setAddress(String address);

}
