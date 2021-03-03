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
@NoArgsConstructor
@AllArgsConstructor
public class MedListElement {

		@Id
		@Column(name = "ml_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@ManyToOne
		@JoinColumn(name = "patient_id")
		Patient patient;
		
		@ManyToOne
		@JoinColumn(name = "drug_id")
		Drug drug;
		
		int fills;

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

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public Drug getDrug() {
			return drug;
		}

		public void setDrug(Drug drug) {
			this.drug = drug;
		}

		public int getFills() {
			return fills;
		}

		public void setFills(int fills) {
			this.fills = fills;
		}
		
}
