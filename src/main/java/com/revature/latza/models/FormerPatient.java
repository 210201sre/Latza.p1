package com.revature.latza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "former_patients", schema = "project1")
@Data @NoArgsConstructor @AllArgsConstructor
public class FormerPatient extends Patient {
	/*fields*/
	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
	private String username;
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
	private String firstName;
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z]*")
	private String lastName;
	@NotBlank
	private String addr;
	
	/*constructors*/
	public FormerPatient() {super();}
	public FormerPatient(int id, @NotBlank @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NotBlank @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String firstName,
			@NotBlank @Pattern(regexp = "[a-zA-Z][a-zA-Z]*") String lastName,
			@NotBlank @Pattern(regexp = "[0-9][a-zA-Z0-9]*") String addr) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr = addr;
	}
	public FormerPatient(Patient r) {
		super();
		this.id = r.getId();
		this.username = r.getUsername();
		this.firstName = r.getFirstName();
		this.lastName = r.getLastName();
		this.addr = r.getAddr();
	}
	/*getters & setters*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
