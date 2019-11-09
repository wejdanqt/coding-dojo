package com.wejdan.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wejdan.web.models.Language;
import com.wejdan.web.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	 public LanguageService(LanguageRepository langRepo) {
	        this.langRepo = langRepo;
	    }
	 
	 public List<Language> allLangs(){
		 return langRepo.findAll();
	 }
	 
	 public Language createLang(Language l) {
		 return langRepo.save(l);
		 
	 }
	 
	  // retrieves a book
	    public Language findLang(Long id) {
	        Optional<Language> optionalLang = langRepo.findById(id);
	        if(optionalLang.isPresent()) {
	            return optionalLang.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Language updateLang(Language l) {
	        return langRepo.save(l);
	    }
	    
	    
		   public void deleteLang(Long id) {
			   langRepo.deleteById(id);
	        }
	 
	

}
