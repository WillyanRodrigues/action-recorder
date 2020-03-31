package br.com.vivo.actionrecorder.dto.request;

public class ActionDTO {
	
	private Double usedData;
	
	private String serviceType;
	
	public Double getUsedData() {
		return usedData;
	}
	public void setUsedData(Double usedData) {
		this.usedData = usedData;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
}
