package com.wejdan.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CounterController {
	int counter = 0 ;

	 @RequestMapping("/")
	    public String index(HttpSession session) {
		 counter++;
	        return "index.jsp";
	    }
	 
	 @RequestMapping("/counter")
	    public String show(HttpSession session) {
	     session.setAttribute("counter", counter);
	        return "show.jsp";
	    }
}
