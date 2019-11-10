package com.wejdan.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wejdan.web.models.Dojo;
import com.wejdan.web.repositories.DojoRepositry;


@Service
public class DojoService {

	private final DojoRepositry dojoRepo;
	
	public DojoService(DojoRepositry dojoRepo) {
		this.dojoRepo = dojoRepo;
		
	}
	
	public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
	
	//add person 
	  public Dojo addDojo(Dojo d) {
	        return dojoRepo.save(d);
	    }
	  
	  //remove person 
	   public void removeDojo(Long id) {
		   dojoRepo.deleteById(id);
       }
	   
	   // Find a dojo
	    public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }

}
