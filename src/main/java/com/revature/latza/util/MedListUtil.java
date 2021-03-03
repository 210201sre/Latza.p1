package com.revature.latza.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.latza.Project1Application;
import com.revature.latza.models.MedListElement;
import com.revature.latza.services.DrugService;
import com.revature.latza.services.FormerPatientService;
import com.revature.latza.services.MedListElementService;
import com.revature.latza.services.PatientService;

public class MedListUtil {
	
	/*fields*/
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);
	
	@Autowired
	private PatientService aPatientService;
	@Autowired 
	private FormerPatientService aFormerPatientService;
	@Autowired
	private DrugService aDrugService;
	@Autowired
	private MedListElementService MLES;
	
	public MedListElement buildMLE(String username, String drugName, String fills) {
		return new MedListElement();
	}
}
