package com.revature.latza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.latza.models.FormerPatient;
import com.revature.latza.services.FormerPatientService;

@RestController
@RequestMapping("/former_patients")
public class FormerPatientController {
	
	@Autowired
	FormerPatientService FPS;
	
	@GetMapping
	public ResponseEntity<List<FormerPatient>> findAll() {
		List<FormerPatient> f = FPS.findAll();
		if(f.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(f);
	}
}
