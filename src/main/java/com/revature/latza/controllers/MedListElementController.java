package com.revature.latza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.latza.Project1Application;
import com.revature.latza.exceptions.DrugNotFoundException;
import com.revature.latza.exceptions.PatientNotFoundException;
import com.revature.latza.models.Drug;
import com.revature.latza.models.MedListElement;
import com.revature.latza.models.Patient;
import com.revature.latza.services.DrugService;
import com.revature.latza.services.FormerPatientService;
import com.revature.latza.services.MedListElementService;
import com.revature.latza.services.PatientService;
import com.revature.latza.util.LoggingUtil;

@RestController
@RequestMapping("/api/v1/Rx")
public class MedListElementController {
	
	/*fields*/
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);
	
	/*beans*/
	@Autowired
	private PatientService aPatientService;
	@Autowired 
	private FormerPatientService aFormerPatientService;
	@Autowired
	private DrugService aDrugService;
	@Autowired
	private MedListElementService MLES;
	
	@PutMapping("/{username}/{med}")
	public ResponseEntity<MedListElement> addRx(@PathVariable(name = "username") String username, @PathVariable(name = "med") String drugname) {
		LoggingUtil.startMDC();
		aLogger.debug("accessed addRx() method of PatientController v1");
		Patient p = new Patient();
		Drug d;
		try{
			aLogger.info("attempting to find patient by username");
			p = aPatientService.findByUsername(username);
			aLogger.info("attempting to find drug by gen name");
			d = aDrugService.findByDrugName(drugname);
		}catch(DrugNotFoundException e) {
			try{
				aLogger.warn("attempting to find drug by brand name");
				d = aDrugService.findByBrandName(drugname);			
			}catch(DrugNotFoundException f) {
				return ResponseEntity.status(516).build();
			}
		}catch( PatientNotFoundException g) {
			return ResponseEntity.status(600).build();
		}
		return ResponseEntity.ok(MLES.save(new MedListElement(p,d)));
	}
	@PutMapping("/{username}/{med}/{fills}")
	public ResponseEntity<MedListElement> addRx(@PathVariable(name = "username") String username, @PathVariable(name = "med") String drugname, @PathVariable(name = "fills") String fills) {
		LoggingUtil.startMDC();
		aLogger.debug("accessed addRx() method of PatientController v1");
		Patient p = new Patient();
		Drug d;
		int f = 1;
		try{
			aLogger.info("sttempting to convert 'fills' to an Integer");
			f = Integer.parseInt(fills);
			aLogger.info("attempting to find patient by username");
			p = aPatientService.findByUsername(username);
			aLogger.info("attempting to find drug by gen name");
			d = aDrugService.findByDrugName(drugname);
		}catch(DrugNotFoundException e) {
			try{
				aLogger.warn("attempting to find drug by brand name");
				d = aDrugService.findByBrandName(drugname);			
			}catch(DrugNotFoundException e2) {
				return ResponseEntity.noContent().build();
			}
		}catch( PatientNotFoundException e) {
			return ResponseEntity.noContent().build();
		}catch(NumberFormatException e) {
			aLogger.warn("bad arg passed for fill count");
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.ok(MLES.save(new MedListElement(p,d,f)));
	}
}
