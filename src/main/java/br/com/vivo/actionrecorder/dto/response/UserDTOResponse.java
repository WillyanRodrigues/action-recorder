package br.com.vivo.actionrecorder.dto.response;

import java.util.List;

public class UserDTOResponse {
	
	private String documentNumber;
	
	private String firstName;
	
	private String lastName;
	
	private List<LineDTOResponse> lines;

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

	public List<LineDTOResponse> getLines() {
		return lines;
	}

	public void setLines(List<LineDTOResponse> lines) {
		this.lines = lines;
	}
	

}
