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
@Table(name = "patients", schema = "project1")
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
	
	/*fields*/
	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
	private String username;
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z]*")
	private String firstName;
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z]*")
	private String lastName;
	@NotBlank
	private String addr;
	
	/*Constructors*/
	public Patient() {super();}
	public Patient(int id, String username, String firstName, String lastName, String addr) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr = addr;
	}


	/*Obj Overrides*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", addr=" + addr + "]";
	}

	/*getters*/
	public String getUsername() {return username;}
	public int getId() {return id;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getAddr() {return addr;}

	/*setters*/
	public void setUsername(String username) {this.username = username;}
	public void setId(int id) {this.id = id;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setAddr(String addr) {this.addr = addr;}
}
