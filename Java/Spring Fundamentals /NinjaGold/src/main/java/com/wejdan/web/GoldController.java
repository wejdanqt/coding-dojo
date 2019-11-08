package com.wejdan.web;



import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GoldController {
	int gold = 0 ;
	ArrayList<String> act=new ArrayList<String>(); 
	
	 @RequestMapping("/")
	    public String index() {
	        return "index.jsp";
	    }
	 @RequestMapping(value="/process_money", method=RequestMethod.POST )
	    public String process_money(HttpSession session ,@RequestParam(value="submit") String place) {
		 if(place.equals("farm")){
			 int random = (int)( 10 + (Math.random() * 20)); 
			 gold += random ;
			  session.setAttribute("gold", gold);
			  String sen = "You enterd a" +place+ "and earned " + random + " gold";
			  act.add(sen);
			  session.setAttribute("act", act);
		 }else if(place.equals("cave")) {
			 int random = (int)( 5 + (Math.random() * 10)); 
			 gold += random ;
			 session.setAttribute("gold", gold);
			 String sen = "You enterd a" +place+ " and earned " + random + " gold";
			 act.add(sen);
			 session.setAttribute("act", act);
			 
		 }else if(place.equals("house")) {
			 int random = (int)( 2 + (Math.random() * 5)); 
			 gold += random ;
			 session.setAttribute("gold", gold);
			 String sen = "You enterd a" +place+ " and earned " + random + " gold";
			 act.add(sen);
			 session.setAttribute("act", act);
			 
		 }else {
			 int random = (int)( -50 + (Math.random() * 50)); 
			 gold += random ;
			 session.setAttribute("gold", gold);
			 if(random > 0 ) {
			 String sen = "You enterd a" +place+ " and earned " + random + " gold";
			 act.add(sen);
			 session.setAttribute("act", act);
				 
			 }else {
				 String sen = "You enterd a " +place+ " and lost " + random + " gold";
				 act.add(sen);
				 session.setAttribute("act", act);
			 }
		 }
		 
		 return "redirect:/";
	    }

}
