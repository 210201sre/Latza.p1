package com.revature.latza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.latza.models.Patient;
import com.revature.latza.services.PatientService;

@Controller
@RequestMapping("/patients")
//the argument being passed to RequestMapping defines the URL prefix for all actions taken regarting the Patient model
public class PatientControler {
	
	@Autowired
	private PatientService patientService;
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
	@ResponseBody
	@GetMapping
	public ResponseEntity<List<Patient>> findAll(){
		System.out.println("INFO-entered the find all method of PatientControler");
		List<Patient> patients = patientService.findAll();
		if (patients.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(patients);
	}
	@ResponseBody
	@GetMapping("/{username}")
	public ResponseEntity<Patient> findByUsername(@PathVariable(name = "username") String username) {
		return ResponseEntity.ok(patientService.findByUsername(username));
	}
	
	//TODO: adapt findByUsername() to findByPatientName()
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Patient> insert(@RequestBody Patient p) {
		System.out.println("INFO-entered the insert method of PatientControler");
		return ResponseEntity.ok(patientService.insert(p));
	}
}