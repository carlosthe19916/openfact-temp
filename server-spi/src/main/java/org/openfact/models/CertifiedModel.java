package org.openfact.models;

import java.io.FileInputStream;
import java.time.LocalDate;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public interface CertifiedModel {

	String getId();

	LocalDate getValidity();

	String getAlias();

	void setAlias(String alias);

	String getCertificate();

	void setCertificate(String certificate);

	String getPassword();

	void setPassword(String password);

	String getPasswordConfirmation();

	void setPasswordConfirmation(String passwordConfirmation);

	OrganizationModel getOrganization();

	void disable();

	boolean isHasCertificate();

	boolean isStatus();

	void setHasCertificate(boolean hasCertificate);
}
