package com.revature.latza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drugs", schema = "project1")
@Data  @AllArgsConstructor
public class Drug {
	
	/*fields*/
	@Id
	@Column(name = "drug_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String brandName;
	@NotBlank
	private String drugName;
	private static Drug nullDrug = buildNullDrug();
	
	/*Constructors*/
	public Drug() {}
	
	/*getters*/
	public int getId() {return id;}
	public String getBrandName() {return brandName;}
	public String getDrugName() {return drugName;}
	public static Drug getNullDrug() {return nullDrug;}
	
	/*setters*/
	public void setId(int id) {this.id = id;}
	public void setBrandName(String brandName) {this.brandName = brandName;}
	public void setDrugName(String drugName) {this.drugName = drugName;}
	
	private static Drug buildNullDrug() {
		Drug d = new Drug();
		d.setId(-1);
		d.setBrandName("nullDrug");
		d.setDrugName("nullDrug");
		return d;
	}

}
