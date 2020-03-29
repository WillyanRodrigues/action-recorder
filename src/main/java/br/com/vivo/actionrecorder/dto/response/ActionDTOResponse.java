package br.com.vivo.actionrecorder.dto.response;

public class ActionDTOResponse {
	
	private Long id;

	private String usedData;
	
	private String serviceType;
	
	public String getUsedData() {
		return usedData;
	}
	public void setUsedData(String usedData) {
		this.usedData = usedData;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
