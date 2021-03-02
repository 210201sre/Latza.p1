package com.revature.latza.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.latza.models.FormerPatient;

public interface FormerPatientDAO extends JpaRepository<FormerPatient, Integer> {
	public Optional<FormerPatient> findByUsername(String username);
	public Optional<FormerPatient> findById(int id);
}
