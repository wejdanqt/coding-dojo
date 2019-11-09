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


import com.wejdan.web.models.Language;
import com.wejdan.web.services.LanguageService;


@Controller
public class LanguageController {
	 private final LanguageService langS ;
	 
	 public LanguageController(LanguageService langS ) {
		 this.langS = langS;
		 
	 }
	 @RequestMapping("/langs")
	public String index(Model model, @ModelAttribute("language") Language lang) {
		 List<Language> langs = langS.allLangs();
		 model.addAttribute("langs", langs);
		return "/langs/index.jsp";
	}
	 
	 @RequestMapping(value="/new", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/langs/index.jsp";
	     } else {
	    	 langS.createLang(lang);
	         return "redirect:/langs";
	     }
	 }
	 
		@RequestMapping(value="/edit/edit/{id}", method=RequestMethod.POST)
		public String modify(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "langs/edit.jsp";
	        }
	        else {
	        	langS.updateLang(language);
	            return "redirect:/langs";
	        }
		}
	 
	 
	 //Show one language info 
	 @RequestMapping("/langs/{id}")
	 public String show(Model model,@PathVariable("id") Long id) {
		 Language langs = langS.findLang(id);
		  model.addAttribute("langs", langs);
	     return "/langs/show.jsp";
	 }
	 
	 
	 

	 @RequestMapping("/langs/edit/{id}")
	 public String edit(@PathVariable("id") Long id, Model model , @ModelAttribute("language") Language language) {
		 Language lang = langS.findLang(id);
	     model.addAttribute("lang", lang);
	     return "/langs/edit.jsp";
	 }
	 
	 //delete method 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public String destroy(@PathVariable("id") Long id) {
		 langS.deleteLang(id);
	     return "redirect:/langs";
	 }
	 
	 

	 

}
