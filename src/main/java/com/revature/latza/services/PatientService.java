package com.revature.latza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.latza.models.Patient;
import com.revature.latza.repositories.PatientDAO;

@Service
public class PatientService {

	@Autowired
	private PatientDAO pDAO;
	
	public List<Patient> findAll() {
		return null;
	}
	public Patient findByUsername(String unsername) {return null;}
	public Patient findById(Integer id) {return null;}
	public Patient insert(Patient newPatient) {return pDAO.save(newPatient);}
	

}
