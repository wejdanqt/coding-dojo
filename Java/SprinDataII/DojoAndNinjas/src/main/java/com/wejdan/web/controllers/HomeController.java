package com.wejdan.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wejdan.web.models.Dojo;
import com.wejdan.web.models.Ninja;
import com.wejdan.web.services.DojoService;
import com.wejdan.web.services.NinjaService;




@Controller
public class HomeController {
	public final DojoService dSrevice;
	public final NinjaService nService;
	
	public HomeController(DojoService dSrevice , NinjaService nService ) {
		this.dSrevice = dSrevice;
		this.nService = nService;
		
	}
	
	//Create new dojo 
	@RequestMapping("/dojos/new")
	 public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
	     return "dojo.jsp";
	 }
	
	@RequestMapping(value="/add/dojo", method=RequestMethod.POST)
	 public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	     if (result.hasErrors()) {
	         return "dojo.jsp";
	     } else {
	    	 dSrevice.addDojo(dojo);
	         return "redirect:/dojos/new";
	     }
	 }
	
	//Create new ninja 
	@RequestMapping("/ninjas/new")
	 public String newNinja(Model model,@ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dSrevice.allDojos();
		model.addAttribute("dojos" , dojos );
	     return "ninja.jsp";
	 }
	
	@RequestMapping(value="/add/ninja", method=RequestMethod.POST)
	 public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
	     if (result.hasErrors()) {
	         return "ninja.jsp";
	     } else {
	    	 nService.addNinja(ninja);
	         return "redirect:/ninjas/new";
	     }
	 }
	
	//Show the ninjas based on locations 
	 @RequestMapping("/dojos/{id}")
	 public String show(Model model,@PathVariable("id") Long id) {
		 Dojo dojo = dSrevice.findDojo(id);
		  model.addAttribute("dojo", dojo);
	     return "show.jsp";
	 }
	
	
	 
	

}
