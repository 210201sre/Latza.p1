package com.revature.latza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.latza.exceptions.DrugNotFoundException;
import com.revature.latza.models.Drug;
import com.revature.latza.repositories.DrugDAO;

@Service
public class DrugService {

	@Autowired
	private DrugDAO dDAO;
	
	public List<Drug> findAll(){
		return dDAO.findAll();
	}
	public Drug findByBrandName(String name) {
		return dDAO.findByBrandName(name).orElseThrow( () -> new DrugNotFoundException("No Drug found with brand name: " + name));
	}
	public Drug findByDrugName(String name) {
		return dDAO.findByDrugName(name).orElseThrow( () -> new DrugNotFoundException("No Drug found with name: " + name));
	}
	public Drug save(Drug newDrug){
		return dDAO.save(newDrug);
		//this method invokes the version from a few levels up the inheritance chain
		//(see JpaRepository which  extends PagingAndSortingRepository which extends CrudRepository)
	}
}
