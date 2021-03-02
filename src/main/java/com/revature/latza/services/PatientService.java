package com.revature.latza.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.latza.exceptions.PatientNotFoundException;
import com.revature.latza.models.Patient;
import com.revature.latza.repositories.PatientDAO;

@Service
public class PatientService {

	@Autowired
	private PatientDAO pDAO;
	
	public List<Patient> findAll() {
		System.out.println("INFO-entered the find all method of PatientService");
		return pDAO.findAll();
	}
	
	public Patient findByUsername(String username) {
		return pDAO.findByUsername(username).orElseThrow( () -> new PatientNotFoundException("No user found with username " + username));
	}

	public Patient findById(int id) {
		return pDAO.findById(id).orElseThrow( () -> new PatientNotFoundException("no user found with id: " + id));
	}

	public Patient save(Patient newPatient) {
		System.out.println("INFO-entered the insert method of PatientService");
		return pDAO.save(newPatient);
		//this method invokes the version from a few levels up the inheritance chain
		//(see JpaRepository which  extends PagingAndSortingRepository which extends CrudRepository)
	}
	
	public void delete(Patient aPatient) {
		pDAO.delete(aPatient);
		//this method invokes the version from a few levels up the inheritance chain
		//(see JpaRepository which  extends PagingAndSortingRepository which extends CrudRepository)
	}

}

