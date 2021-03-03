package com.revature.latza.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.latza.Project1Application;
import com.revature.latza.models.FormerPatient;
import com.revature.latza.services.FormerPatientService;
import com.revature.latza.util.MyLoggingUtil;

@RestController
@RequestMapping("/former_patients")
public class FormerPatientController {
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);

	@Autowired
	FormerPatientService FPS;
	
	@GetMapping
	public ResponseEntity<List<FormerPatient>> findAll() {
		MyLoggingUtil.startMDC();
		List<FormerPatient> f = FPS.findAll();
		MDC.clear();
		if(f.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(f);
	}
}
