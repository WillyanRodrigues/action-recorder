package br.com.vivo.actionrecorder.dto.response;

import br.com.vivo.actionrecorder.dto.request.PlanDTO;

public class LineDTOResponse {

	private Long id;
	
	private int countryCode;
	
	private int areaCode;
	
	private Long number;

	private PlanDTO planDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public PlanDTO getPlanDTO() {
		return planDTO;
	}

	public void setPlanDTO(PlanDTO planDTO) {
		this.planDTO = planDTO;
	}


	
	
}
