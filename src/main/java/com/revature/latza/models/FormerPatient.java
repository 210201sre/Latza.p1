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
public class FormerPatient {
	/*fields*/
	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String addr;
	
	/*constructors*/

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
	@Override
	public String toString() {
		return "FormerPatient [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", addr=" + addr + "]";
	}
	
	
}
