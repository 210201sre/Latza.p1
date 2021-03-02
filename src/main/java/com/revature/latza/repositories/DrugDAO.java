package com.revature.latza.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.latza.models.Drug;

public interface DrugDAO extends JpaRepository<Drug, Integer> {
	public Optional<Drug> findByBrandName(String name);
	public Optional<Drug> findByDrugName(String name);
}
