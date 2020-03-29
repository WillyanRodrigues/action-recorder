package br.com.vivo.actionrecorder.dto.response;

import java.util.List;

public class LineDTOResponse {

	private Long id;
	
	private int countryCode;
	
	private int areaCode;
	
	private Long number;

	private String planType;
	
	private List<ActionDTOResponse> actions;

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

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public List<ActionDTOResponse> getActions() {
		return actions;
	}

	public void setActions(List<ActionDTOResponse> actions) {
		this.actions = actions;
	}
	
	
}
