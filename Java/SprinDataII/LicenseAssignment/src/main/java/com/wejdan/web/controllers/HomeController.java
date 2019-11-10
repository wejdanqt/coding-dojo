package com.wejdan.web.controllers;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wejdan.web.models.License;
import com.wejdan.web.models.Person;
import com.wejdan.web.services.LicenseService;
import com.wejdan.web.services.PersonService;





@Controller
public class HomeController {
	
	public final PersonService pService;
	public final LicenseService lService;
	private static int counter = 0;
	
	public HomeController( PersonService pService ,LicenseService lService) {
		this.pService = pService ;
		this.lService = lService;
		
	}
	
	 //Create new Person 
	 @RequestMapping("/persons/new")
	 public String newBook(@ModelAttribute("person") Person person) {
	     return "person.jsp";
	 }
	 
	 @RequestMapping(value="/add/person", method=RequestMethod.POST)
	 public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	     if (result.hasErrors()) {
	         return "person.jsp";
	     } else {
	    	 pService.addPerson(person);
	         return "redirect:/persons/new";
	     }
	 }
	 
	 //create new license 
	 @RequestMapping("/licenses/new")
	 public String newLicense(Model model ,@ModelAttribute("license") License license) {
		 List<Person> persons = pService.allPersons() ;
		 model.addAttribute("persons" , persons );
	     return "license.jsp";
	 }
	 
	 @RequestMapping(value="/add/license", method=RequestMethod.POST)
	 public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
	     if (result.hasErrors()) {
	         return "license.jsp";
	     } else {
	    	 counter += 1;
		     NumberFormat formatter = new DecimalFormat("00000");
			 String licenseNumber = formatter.format(counter);
			 license.setNumber(licenseNumber);
	    	 lService.addLicense(license);
	         return "redirect:/licenses/new";
	     }
	 }
	 
	 //Show person 
	 @RequestMapping("/persons/{id}")
	 public String show(Model model,@PathVariable("id") Long id) {
		 Person person = pService.findPerson(id);
		  model.addAttribute("person", person);
	     return "show.jsp";
	 }
	 
	 
	 

}
