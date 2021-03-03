package com.revature.latza.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.latza.models.Patient;

public interface PatientDAO extends JpaRepository<Patient, Integer>{
	public Optional<Patient> findByUsername(String username);
	public Optional<Patient> findById(int id);
	
	@Modifying
	@Query(value = "UPDATE project1.patients SET addr = :newAddr WHERE username = :username", nativeQuery = true)
	@Transactional
	public void updateAddr(@Param("username") String username, @Param("newAddr") String newAddr);

}