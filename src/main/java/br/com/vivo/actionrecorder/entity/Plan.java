package br.com.vivo.actionrecorder.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	@Enumerated(EnumType.STRING)
	private PlanType type;
	
	@Column
	@Digits(integer=5, fraction=2)
	private BigDecimal price;
	
	@Column
	private Double internetLimit;
	
	@Column
	private Integer callLimit;
	
	@Column
	private Integer smsLimit;

	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public PlanType getType() {
		return type;
	}

	public void setType(PlanType type) {
		this.type = type;
	}

	public Double getInternetLimit() {
		return internetLimit;
	}

	public void setInternetLimit(Double internetLimit) {
		this.internetLimit = internetLimit;
	}

	public Integer getCallLimit() {
		return callLimit;
	}

	public void setCallLimit(Integer callLimit) {
		this.callLimit = callLimit;
	}

	public Integer getSmsLimit() {
		return smsLimit;
	}

	public void setSmsLimit(Integer smsLimit) {
		this.smsLimit = smsLimit;
	}

	
	
	
}
