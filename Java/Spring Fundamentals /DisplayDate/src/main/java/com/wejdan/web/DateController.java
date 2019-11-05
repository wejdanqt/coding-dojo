package com.wejdan.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class DateController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
		
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date dateOB = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat( "EEEEE, dd MMMMM, yyyy" );
		String date = dateFormat.format(dateOB);
		model.addAttribute("date", date);
		return "date.jsp";
		
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new java.util.Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat( "hh:mm a" );
		String time = timeFormat.format(date);
		model.addAttribute("time", time);
		return "time.jsp";
		
	}


}
