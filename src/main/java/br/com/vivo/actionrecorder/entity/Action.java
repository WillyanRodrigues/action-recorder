package br.com.vivo.actionrecorder.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Action {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long actionId;
	
	@Column(nullable = false)
	private Double consumedData;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ServiceType serviceType;
	
	@ManyToOne
	@JoinColumn(name = "lineId", nullable = false)
	private Line line;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
    private Date date;


	public Double getConsumedData() {
		return consumedData;
	}

	public void setConsumedData(Double consumedData) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
}
