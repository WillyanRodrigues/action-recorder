package br.com.vivo.actionrecorder.dto.request;

public class ConsumeLimitDTO {
	
	private Double internet;
	
	private Integer call;
	
	private Integer sms;

	public Double getInternet() {
		return internet;
	}

	public void setInternet(Double internet) {
		this.internet = internet;
	}

	public Integer getCall() {
		return call;
	}

	public void setCall(Integer call) {
		this.call = call;
	}

	public Integer getSms() {
		return sms;
	}

	public void setSms(Integer sms) {
		this.sms = sms;
	}

	
}
