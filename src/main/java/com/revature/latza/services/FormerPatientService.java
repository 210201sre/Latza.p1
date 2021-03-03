package com.revature.latza.services;

import java.util.List;

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
	
	public FormerPatient findByUsername(String username) {
		return fDAO.findByUsername(username).orElseThrow( () -> new PatientNotFoundException("No former patient found with username " + username));
	}
	
	public FormerPatient findById(int id) {
		return fDAO.findById(id).orElseThrow( () -> new PatientNotFoundException("no former patient found with id: " + id));
	}
	
	public FormerPatient save(FormerPatient aFormerPatient) {
		System.out.println("INFO-entered the insert method of FormerPatientService: " + aFormerPatient.toString());
		FormerPatient f = fDAO.save(aFormerPatient);
		//this method invokes the version from a few levels up the inheritance chain
		//(see JpaRepository which  extends PagingAndSortingRepository which extends CrudRepository)
		System.out.println("INFO-leaving the insert method of FormerPatientService: " + aFormerPatient.toString());
		return f;
	}
	
	public List<FormerPatient> findAll() {
		return fDAO.findAll();
	}
}
