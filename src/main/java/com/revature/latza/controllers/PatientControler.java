package com.revature.latza.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.latza.Project1Application;
import com.revature.latza.exceptions.DrugNotFoundException;
import com.revature.latza.exceptions.PatientAlreadyPresentException;
import com.revature.latza.exceptions.PatientNotFoundException;
import com.revature.latza.models.Drug;
import com.revature.latza.models.FormerPatient;
import com.revature.latza.models.MedListElement;
import com.revature.latza.models.Patient;
import com.revature.latza.services.DrugService;
import com.revature.latza.services.FormerPatientService;
import com.revature.latza.services.MedListElementService;
import com.revature.latza.services.PatientService;
import com.revature.latza.util.LoggingUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/v1/patients")
//the argument being passed to RequestMapping defines the URL prefix for all actions taken regarting the Patient model
public class PatientControler {
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);

	@Autowired
	private PatientService aPatientService;
	@Autowired 
	private FormerPatientService aFormerPatientService;
	@Autowired
	private DrugService aDrugService;
	@Autowired
	private MedListElementService MLES;
	//@Autowired invokes inversion of control by obtaining a spring bean/reference to a 
	//singleton bean from the SpringContainer
	
	/*@ResponseBody
	 * "tells a controller that the object returned is automatically serialized into JSON 
	 * and passed back into the HttpResponse object."
	 * https://www.baeldung.com/spring-request-response-body
	 */
	/*@GetMapping
	 * abstracts use of @RequestMapping. 
	 * @RequestMapping should be read as "the following method/type needs mapping and is related 
	 * to an HTTP Request" and not at "I am requesting mapping for the following method/type"
	 */
	@GetMapping
	public ResponseEntity<List<Patient>> findAll(){
		LoggingUtil.startMDC();
		aLogger.info("entered the find all method of PatientControler");
		
		List<Patient> patients = aPatientService.findAll();
		
		if (patients.isEmpty())
			return ResponseEntity.noContent().build();
		MDC.clear();
		return ResponseEntity.ok(patients);
	}	
	@GetMapping("/first_name/{fName}")
	public ResponseEntity<List<Patient>> findByFisrtName(@PathVariable(name = "fName") String name){
		LoggingUtil.startMDC();
		aLogger.info("entered the find by first name method of PatientControler");
		
		List<Patient> patients = aPatientService.findAll();
		List<Patient> patients2 = new ArrayList<Patient>();
		
		for (Patient p : patients) {
			if (p.getFirstName().equals(name))
				patients2.add(p);
		}
		MDC.clear();
		if (patients2.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(patients2);
	}
	@GetMapping("/last_name/{lName}")
	public ResponseEntity<List<Patient>> findByLastName(@PathVariable(name = "lName") String name){
		LoggingUtil.startMDC();
		aLogger.info("entered the find by last name method of PatientControler");
		
		List<Patient> patients = aPatientService.findAll();
		List<Patient> patients2 = new ArrayList<Patient>();
		
		for (Patient p : patients) {
			if (p.getLastName().equals(name))
				patients2.add(p);
		}
		MDC.clear();
		if (patients2.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(patients2);
	}
	@GetMapping("/usernames/{username}")
	public ResponseEntity<Patient> findByUsername(@PathVariable(name = "username") String username) {
		LoggingUtil.startMDC();
		MDC.clear();
		return ResponseEntity.ok(aPatientService.findByUsername(username));
		//TODO:fix return no user found
	}
	@GetMapping("/ids/{id}")
	public ResponseEntity<Patient> findById(@PathVariable(name = "id") int id){
		LoggingUtil.startMDC();
		MDC.clear();
		return ResponseEntity.ok(aPatientService.findById(id));
		//TODO:fix return no user found
	}
	@PostMapping
	public ResponseEntity<Patient> save(@RequestBody Patient p) {
		LoggingUtil.startMDC();
		try {
			aLogger.info("entered the insert method of PatientControler");
			MDC.clear();
			return ResponseEntity.ok(aPatientService.save(p));
		}catch(PatientAlreadyPresentException e) {
			MDC.clear();
			return ResponseEntity.noContent().build();
		}
	}
	@PutMapping("/anti-patients/{username}")
	public void delete(@PathVariable(name = "username") String username){
		LoggingUtil.startMDC();
		aLogger.info("entered the delete() method of patient controler. username: "+username);
		Patient thePatient = findByUsername(username).getBody();
		aFormerPatientService.save(new FormerPatient(thePatient));
		aPatientService.delete(thePatient);
		MDC.clear();
	}
	
	
	
	@PutMapping("/addr/{username}/{addr}")
	public void newAddr(@PathVariable(name = "username") String username, @PathVariable(name = "addr") String addr) {
		LoggingUtil.startMDC();
		aLogger.info("attempting to update addr of: "+username.toUpperCase()+" to: "+addr);
		aPatientService.newAddr(username, addr);
		MDC.clear();
	}

	
	
}