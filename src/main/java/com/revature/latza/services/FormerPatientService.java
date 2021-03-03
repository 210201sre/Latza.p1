package com.revature.latza.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.latza.Project1Application;
import com.revature.latza.exceptions.PatientNotFoundException;
import com.revature.latza.models.FormerPatient;
import com.revature.latza.models.Patient;
import com.revature.latza.repositories.FormerPatientDAO;

@Service
public class FormerPatientService {
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);

	@Autowired
	private FormerPatientDAO fDAO;
	
	public FormerPatient findByUsername(String username) {
		return fDAO.findByUsername(username).orElseThrow( () -> new PatientNotFoundException("No former patient found with username " + username));
	}
	
	public FormerPatient findById(int id) {
		return fDAO.findById(id).orElseThrow( () -> new PatientNotFoundException("no former patient found with id: " + id));
	}
	
	public FormerPatient save(FormerPatient aFormerPatient) {
		aLogger.info("entered the insert method of FormerPatientService: " + aFormerPatient.toString());
		FormerPatient f = fDAO.save(aFormerPatient);
		//this method invokes the version from a few levels up the inheritance chain
		//(see JpaRepository which  extends PagingAndSortingRepository which extends CrudRepository)
		aLogger.info("leaving the insert method of FormerPatientService: " + aFormerPatient.toString());
		return f;
	}
	
	public List<FormerPatient> findAll() {
		return fDAO.findAll();
	}
}
