package br.com.vivo.actionrecorder.dto.request;

import javax.validation.constraints.NotNull;

public class UserDTO {

	@NotNull
	private String documentNumber;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
}
