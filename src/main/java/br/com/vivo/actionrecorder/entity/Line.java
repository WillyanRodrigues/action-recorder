package br.com.vivo.actionrecorder.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Line {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lineId;
	
	@Column(nullable = false)
	private int countryCode;
	
	@Column(nullable = false)
	private int areaCode;
	
	@Column(unique = true , nullable = false)
	private Long number;

	@ManyToOne(optional = false)
	private Plan plan;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name= "lineId")
	private List<Action> actions;
	
	@ManyToOne(cascade = CascadeType.ALL)
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


	public Long getLineId() {
		return lineId;
	}


	public List<Action> getActions() {
		return actions;
	}


	public void setActions(List<Action> actions) {
		this.actions = actions;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
