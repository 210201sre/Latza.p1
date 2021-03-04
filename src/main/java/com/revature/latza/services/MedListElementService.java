package com.revature.latza.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.latza.Project1Application;
import com.revature.latza.models.Drug;
import com.revature.latza.models.MedListElement;
import com.revature.latza.models.Patient;
import com.revature.latza.repositories.DrugDAO;
import com.revature.latza.repositories.MedListElementDAO;
import com.revature.latza.repositories.PatientDAO;

@Service
public class MedListElementService {
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);

	@Autowired
	MedListElementDAO mDAO;
	@Autowired
	PatientDAO pDAO;
	@Autowired
	private DrugDAO dDAO;
	
	
	public MedListElement save(MedListElement m) {
		aLogger.info("enternd save method of MLEService ");
		return mDAO.save(m);
	}
	
	public void updateFills(String username, String drugname, String fills) {
		aLogger.info("entered addFills() of MLE service");
		
		Patient p = pDAO.findByUsername(username).get();
		Drug d;
		try{
			d = dDAO.findByDrugName(drugname).get();
		}catch(RuntimeException e) {
			d = dDAO.findByBrandName(drugname).get();
		}
		
		mDAO.updateFills(p.getId(), d.getId(), Integer.parseInt(fills));
	}
}
