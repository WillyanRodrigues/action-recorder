package br.com.vivo.actionrecorder.dto.response;

import java.time.LocalDateTime;

public class ActionDTOResponse {
	
	private Long id;

	private Double usedData;
	
	private String serviceType;
	
	private LocalDateTime date;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
	
}
