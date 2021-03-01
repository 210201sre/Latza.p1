package com.revature.latza.controllers;

import java.util.ArrayList;
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

import com.revature.latza.models.FormerPatient;
import com.revature.latza.models.Patient;
import com.revature.latza.services.FormerPatientService;
import com.revature.latza.services.PatientService;

@Controller
@RequestMapping("/patients")
//the argument being passed to RequestMapping defines the URL prefix for all actions taken regarting the Patient model
public class PatientControler {
	
	@Autowired
	private PatientService aPatientService;
	@Autowired 
	FormerPatientService aFormerPatientService;
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
		
		List<Patient> patients = aPatientService.findAll();
		
		if (patients.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(patients);
	}	
	@ResponseBody
	@GetMapping("/first_name/{fName}")
	public ResponseEntity<List<Patient>> findByFisrtName(@PathVariable(name = "fName") String name){
		System.out.println("INFO-entered the find by first name method of PatientControler");
		
		List<Patient> patients = aPatientService.findAll();
		List<Patient> patients2 = new ArrayList<Patient>();
		
		for (Patient p : patients) {
			if (p.getFirstName().equals(name))
				patients2.add(p);
		}
		
		if (patients2.isEmpty())
			return ResponseEntity.noContent().build();

		
		return ResponseEntity.ok(patients2);
	}
	@ResponseBody
	@GetMapping("/last_name/{lName}")
	public ResponseEntity<List<Patient>> findByLastName(@PathVariable(name = "lName") String name){
		System.out.println("INFO-entered the find by last name method of PatientControler");
		
		List<Patient> patients = aPatientService.findAll();
		List<Patient> patients2 = new ArrayList<Patient>();
		
		for (Patient p : patients) {
			if (p.getLastName().equals(name))
				patients2.add(p);
		}
		
		if (patients2.isEmpty())
			return ResponseEntity.noContent().build();

		
		return ResponseEntity.ok(patients2);
	}
	@ResponseBody
	@GetMapping("/usernames/{username}")
	public ResponseEntity<Patient> findByUsername(@PathVariable(name = "username") String username) {
		return ResponseEntity.ok(aPatientService.findByUsername(username));
		//TODO:fix return no user found
	}
	@GetMapping("/ids/{id}")
	@ResponseBody
	public ResponseEntity<Patient> findById(@PathVariable(name = "id") int id){
		return ResponseEntity.ok(aPatientService.findById(id));
		//TODO:fix return no user found
	}
	@PutMapping
	@ResponseBody
	public ResponseEntity<Patient> save(@RequestBody Patient p) {
		System.out.println("INFO-entered the insert method of PatientControler");
		return ResponseEntity.ok(aPatientService.save(p));
	}
	@ResponseBody
	@PostMapping("/anti-patients/{username}")
	public void delete(@PathVariable(name = "username") String username){
		Patient thePatient = findByUsername(username).getBody();
		aFormerPatientService.save(new FormerPatient(thePatient));
		aPatientService.delete(thePatient);
	}
}