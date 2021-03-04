package com.revature.latza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.revature.latza.models.MedListElement;

public interface MedListElementDAO extends JpaRepository<MedListElement, Integer> {
	
	@Modifying
	@Query(value = "UPDATE project1.patient_meds SET fills = :fills WHERE patient_id = :pId and drug_id = :dId", nativeQuery = true)
	@Transactional
	public void updateFills(int pId, int dId, int fills);
}
