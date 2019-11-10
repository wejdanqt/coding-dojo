package com.wejdan.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wejdan.web.models.Ninja;
import com.wejdan.web.repositories.NinjaRepositry;


@Service
public class NinjaService {

	private final NinjaRepositry ninjaRepo;
	
	public NinjaService(NinjaRepositry ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
		
	}
	
	public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
	
	//add person 
	  public Ninja addNinja(Ninja n) {
	        return ninjaRepo.save(n);
	    }
	  
	  //remove person 
	   public void removeNinja(Long id) {
		   ninjaRepo.deleteById(id);
       }
	   
	   

}
