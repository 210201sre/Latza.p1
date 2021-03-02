package com.revature.latza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.latza.models.MedListElement;

public interface MedListElementDAO extends JpaRepository<MedListElement, Integer> {

}
