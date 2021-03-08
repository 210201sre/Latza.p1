package com.revature.latza.controllers;

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
import com.revature.latza.models.Drug;
import com.revature.latza.services.DrugService;
import com.revature.latza.util.LoggingUtil;

@RestController
@RequestMapping("/api/v1/drugs")
public class DrugControler {
	private static final Logger aLogger = LoggerFactory.getLogger(Project1Application.class);

	@Autowired
	private DrugService aDrugService;
	
	//get all drugs
	@GetMapping
	public ResponseEntity<List<Drug>> findAll(){
		LoggingUtil.startMDC();
		aLogger.info("entered findAll() of Drug class");
		List<Drug> drugs = aDrugService.findAll();
		if(drugs.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(drugs);
	}
	//get drug by brand
	@GetMapping("/{name}")
	public ResponseEntity<Drug> findByBrandName1(@PathVariable(name = "name") String name){		
		LoggingUtil.startMDC();
		Drug aDrug;
		try{
			aDrug = aDrugService.findByBrandName(name);
		}catch(DrugNotFoundException e) {
			aDrug = aDrugService.findByDrugName(name);
		}
		MDC.clear();
		return ResponseEntity.ok(aDrug);
	}
	//add drug
	@PostMapping
	public ResponseEntity<Drug> save(@RequestBody Drug d){
		LoggingUtil.startMDC();
		MDC.clear();
		return ResponseEntity.ok(aDrugService.save(d));
	}
}
