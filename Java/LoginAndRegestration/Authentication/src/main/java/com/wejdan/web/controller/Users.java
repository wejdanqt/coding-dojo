package com.wejdan.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wejdan.web.models.User;
import com.wejdan.web.service.UserService;

@Controller
public class Users {
    private final UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	  if (result.hasErrors()) {
    	         return "registrationPage.jsp";
    	     } else {
    	    	 User u = userService.registerUser(user);
    	    	 session.setAttribute("id", u.getId());
    	         return "redirect:/home";
    	     }
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	if(userService.authenticateUser(email , password )) {
    		User user = userService.findByEmail(email);
    		 session.setAttribute("id", user.getId());
    		 return "redirect:/home";
    		 
    		
    	}else {
    		model.addAttribute("error", "Invalid");
    		 return "loginPage.jsp";
    		
    	}
    	
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	User user = userService.findUserById((Long)(session.getAttribute("id")));
    	model.addAttribute("user", user);
    	    return "homePage.jsp";
    	    
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
   	 return "redirect:/login";
   	 
    	
    }
}