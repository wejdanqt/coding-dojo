package com.wejdan.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wejdan.web.models.License;

import com.wejdan.web.repositories.LicensesRepository;

@Service
public class LicenseService {
	private final LicensesRepository licenseRepo;
	
	public LicenseService(LicensesRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
		
	}
	
	public List<License> allPersons() {
        return licenseRepo.findAll();
    }
	
	//add person 
	  public License addLicense(License l) {
	        return licenseRepo.save(l);
	    }
	  
	  //remove person 
	   public void removeLicense(Long id) {
		   licenseRepo.deleteById(id);
       }

}
