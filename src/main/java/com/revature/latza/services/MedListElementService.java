package com.revature.latza.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.latza.Project1Application;
import com.revature.latza.models.MedListElement;
import com.revature.latza.repositories.MedListElementDAO;

@Service
public class MedListElementService {
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);

	@Autowired
	MedListElementDAO mDAO;
	
	public MedListElement save(MedListElement m) {
		aLogger.info("enternd save method of MLEService ");
		return mDAO.save(m);
	}
}
