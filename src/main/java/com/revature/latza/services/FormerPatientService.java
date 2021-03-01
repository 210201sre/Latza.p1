package com.revature.latza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.latza.exceptions.PatientNotFoundException;
import com.revature.latza.models.FormerPatient;
import com.revature.latza.models.Patient;
import com.revature.latza.repositories.FormerPatientDAO;

@Service
public class FormerPatientService {
	@Autowired
	private FormerPatientDAO fDAO;
	public Patient findByUsername(String username) {
		return fDAO.findByUsername(username).orElseThrow( () -> new PatientNotFoundException("No former patient found with username " + username));
	}
	public Patient findById(int id) {
		return fDAO.findById(id).orElseThrow( () -> new PatientNotFoundException("no former patient found with id: " + id));
	}
	public Patient save(FormerPatient newPatient) {
		System.out.println("INFO-entered the insert method of PatientService");
		return fDAO.save(newPatient);
	}
}
