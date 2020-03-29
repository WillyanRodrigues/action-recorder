package br.com.vivo.actionrecorder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Line {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int countryCode;
	
	@Column
	private int areaCode;
	
	@Column
	private Long number;

	@ManyToOne
	private Plan plan;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

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


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public Long getId() {
		return id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
