package com.wejdan.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class StringsAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsAssignmentApplication.class, args);
	}
	
	 @RequestMapping("/")
     // 3. Method that maps to the request route above
     public String hello() { // 3
             return "Hello Client!How are you doing?";
     }
	 
	 @RequestMapping("/random")
     // 3. Method that maps to the request route above
     public String random() { // 3
             return "Spring boot is great!So easy to just respond with strings";
     }

}
