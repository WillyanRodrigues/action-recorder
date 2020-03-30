package br.com.vivo.actionrecorder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Action {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long actionId;
	
	@Column
	private String consumedData;
	
	@Enumerated(EnumType.STRING)
	private ServiceType serviceType;
	
	@ManyToOne
	@JoinColumn(name = "lineId")
	private Line line;


	public String getConsumedData() {
		return consumedData;
	}

	public void setConsumedData(String consumedData) {
		this.consumedData = consumedData;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Long getActionId() {
		return actionId;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	
	
	
}
