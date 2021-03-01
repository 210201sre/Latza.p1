package com.revature.latza.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.latza.models.Patient;

public interface PatientDAO extends JpaRepository<Patient, Integer>{
	public Optional<Patient> findByUsername(String username);
	public Optional<Patient> findById(int id);

}