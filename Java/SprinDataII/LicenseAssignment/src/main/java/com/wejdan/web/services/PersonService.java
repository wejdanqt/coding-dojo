package com.wejdan.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wejdan.web.models.Person;
import com.wejdan.web.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
		
	}
	
	public List<Person> allPersons() {
        return personRepo.findAll();
    }
	
	//add person 
	  public Person addPerson(Person p) {
	        return personRepo.save(p);
	    }
	  
	  //remove person 
	   public void removePerson(Long id) {
		   personRepo.deleteById(id);
       }
	   
	   // Find a person
	    public Person findPerson(Long id) {
	        Optional<Person> optionalPerson = personRepo.findById(id);
	        if(optionalPerson.isPresent()) {
	            return optionalPerson.get();
	        } else {
	            return null;
	        }
	    }

}
