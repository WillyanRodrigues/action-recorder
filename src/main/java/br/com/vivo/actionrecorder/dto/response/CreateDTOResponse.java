package br.com.vivo.actionrecorder.dto.response;

public class CreateDTOResponse {
	
	private Long id;

	public CreateDTOResponse(Long id) {
		setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
