package br.com.vivo.actionrecorder.dto.request;

import java.math.BigDecimal;

import br.com.vivo.actionrecorder.entity.PlanType;

public class PlanDTO {
		

	private PlanType type;
	
	private BigDecimal price;
	
	private ConsumeLimitDTO consumeLimit;
	
	
	public PlanType getType() {
		return type;
	}

	public void setType(PlanType type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ConsumeLimitDTO getConsumeLimit() {
		return consumeLimit;
	}

	public void setConsumeLimit(ConsumeLimitDTO consumeLimit) {
		this.consumeLimit = consumeLimit;
	}

}
