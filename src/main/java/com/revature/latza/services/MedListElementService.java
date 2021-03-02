package com.revature.latza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.latza.models.MedListElement;
import com.revature.latza.repositories.MedListElementDAO;

@Service
public class MedListElementService {

	@Autowired
	MedListElementDAO mDAO;
	
	public MedListElement save(MedListElement m) {
		System.out.println("enternd save method of MLEService ");
		return mDAO.save(m);
	}
}
