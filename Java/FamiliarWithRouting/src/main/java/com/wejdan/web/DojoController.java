package com.wejdan.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class DojoController {
	@RequestMapping("/{str}")
	  public String show(@PathVariable("str") String str){
		if(str.equals("dojo")) {
			str =  "The dojo is awesome!";
		}if(str.equals("burbank-dojo")) {
			str =  "Burbank Dojo is located in Southern California";
		}if(str.equals("san-jose")) {
			str =  "SJ dojo is the headquarters";
		}
		return str;
		
    }
	


}
