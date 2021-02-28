package com.revature.latza.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.latza.models.Patient;

public interface PatientDAO extends JpaRepository<Patient, Integer>{
	public Optional<Patient> findByUsername(String username);
	/*
	 * 	@Transactional // Include this annotation if you want this to be part of a transaction
	 *	@Modifying // Include this annotation if you intend to manipulate data, such as with INSERT, UPDATE, or DELETE
	 *	@Query(value = "FROM User WHERE email LIKE %:substr%") // Use this to write custom SQL or HQL
	 *	public List<User> findByEmailContains(String substr);
	*/
}