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
@Data @AllArgsConstructor
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
	
	private static Patient nullPatient = buildNullPatient();


	/*constructors*/
	public Patient() {super();}
	
	/*getters*/
	public String getUsername() {return username;}
	public int getId() {return id;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getAddr() {return addr;}
	public static Patient getNullPatient() {return nullPatient;}

	/*setters*/
	public void setUsername(String username) {this.username = username;}
	public void setId(int id) {this.id = id;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setAddr(String addr) {this.addr = addr;}
	
	public static Patient buildNullPatient() {
		Patient p = new Patient();
		p.setId(-1);
		p.setFirstName("nullPatient");
		p.setLastName("nullPatient");
		p.setAddr("nullPatient");
		return p;
	}
}
