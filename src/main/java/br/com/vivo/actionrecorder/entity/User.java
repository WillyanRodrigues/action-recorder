package br.com.vivo.actionrecorder.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(unique = true, nullable = false ,  length = 11)
	private Long documentNumber;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true , cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<Line> line;
	
	
	public User() {
		
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public Long getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Line> getLine() {
		return line;
	}

	public void setLine(List<Line> line) {
		this.line = line;
	}

	
}
