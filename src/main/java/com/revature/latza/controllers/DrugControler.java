package com.revature.latza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.latza.exceptions.DrugNotFoundException;
import com.revature.latza.models.Drug;
import com.revature.latza.services.DrugService;

@RestController
@RequestMapping("/drugs")
public class DrugControler {
	
	@Autowired
	private DrugService aDrugService;
	
	//get all drugs
	@GetMapping
	public ResponseEntity<List<Drug>> findAll(){
		List<Drug> drugs = aDrugService.findAll();
		if(drugs.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(drugs);
	}
	//get drug by brand
	@GetMapping("/{name}")
	public ResponseEntity<Drug> findByBrandName1(@PathVariable(name = "name") String name){		
		Drug aDrug;
		try{
			aDrug = aDrugService.findByBrandName(name);
		}catch(DrugNotFoundException e) {
			aDrug = aDrugService.findByDrugName(name);
		}
		return ResponseEntity.ok(aDrug);
	}
	//add drug
	@PutMapping
	public ResponseEntity<Drug> save(@RequestBody Drug d){
		return ResponseEntity.ok(aDrugService.save(d));
	}
}
