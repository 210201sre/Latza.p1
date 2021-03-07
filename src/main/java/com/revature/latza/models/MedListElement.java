package com.revature.latza.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "patient_meds", schema = "project1")
@Data
@AllArgsConstructor
public class MedListElement {

		@Id
		@Column(name = "ml_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@ManyToOne
		@JoinColumn(name = "patient_id")
		private Patient patient;
		@ManyToOne
		@JoinColumn(name = "drug_id")
		private Drug drug;
		private int fills;
		
		
		/*constructors*/
		public MedListElement() {}
		public MedListElement(Patient p, Drug d) {
			this.patient = p;
			this.drug = d;
			fills = 0;
		}
		public MedListElement(Patient p, Drug d, int fillCount) {
			this.patient = p;
			this.drug = d;
			fills = fillCount;
		}

		/*getters*/
		public int getId() {return id;}
		public Patient getPatient() {return patient;}
		public Drug getDrug() {return drug;}
		public int getFills() {return fills;}

		/*setters*/
		public void setId(int id) {this.id = id;}
		public void setPatient(Patient patient) {this.patient = patient;}
		public void setDrug(Drug drug) {this.drug = drug;}
		public void setFills(int fills) {this.fills = fills;}

}
