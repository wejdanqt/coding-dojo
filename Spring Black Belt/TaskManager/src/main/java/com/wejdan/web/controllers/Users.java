package com.wejdan.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wejdan.web.models.Task;
import com.wejdan.web.models.User;
import com.wejdan.web.services.TaskService;
import com.wejdan.web.services.UserService;
import com.wejdan.web.validator.UserValidator;

@Controller
public class Users {
	 private UserService userService;
	 private UserValidator userValidator;
	 private TaskService taskService;

	 
	 
	 public Users(UserService userService , UserValidator userValidator , TaskService taskService) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	        this.taskService = taskService;
	    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	  // NEW
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
 
    
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model , HttpSession session) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        
		 
        return "registrationPage.jsp";
    }
    
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model , HttpSession session) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        List<Task> tasks = taskService.allTasks();
        model.addAttribute("tasks", tasks);
        return "homePage.jsp";
    }
    
    @RequestMapping("/tasks/Asc")
    public String showTasksAsc(Principal principal,Model model,HttpSession session) {
    	
    	 String username = principal.getName();
         model.addAttribute("currentUser", userService.findByUsername(username));
         List<Task> tasks = taskService.allTasksAsc();
         model.addAttribute("tasks", tasks);
        return "homePage.jsp";
    }
    
    @RequestMapping("/tasks/Dsc")
    public String showTasksDes(Principal principal , Model model,HttpSession session) {    

   	 String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        List<Task> tasks = taskService.allTasksDesc();
        model.addAttribute("tasks", tasks);
        return "homePage.jsp";
    }
    
    
    
   
    
    
	//Create new task page 
	@RequestMapping("/tasks/new")
	 public String newTasks (Principal principal , Model model,@ModelAttribute("task") Task task , HttpSession session) {
			List<User> users = userService.allUsers();
		    String username = principal.getName();
	        model.addAttribute("currentUser", userService.findByUsername(username));
	        
			model.addAttribute("users" , users );
	     return "NewTask.jsp";
	 }
	
	 //delete method 
	 @RequestMapping(value="/task/delete/{id}", method=RequestMethod.GET)
	 public String destroy(@PathVariable("id") Long id) {
		 taskService.removeTask(id);
		 return "redirect:/";
	 }
	
	//add task 
	@RequestMapping(value="/add/task", method=RequestMethod.POST)
	 public String addTask(Model model,@Valid @ModelAttribute("task") Task task, BindingResult result) {
	     if (result.hasErrors()) {
	    	 List<User> users = userService.allUsers();
	    		model.addAttribute("users" , users );
	    	 
	    
	         return "NewTask.jsp";
	     } else {
	    	 System.out.println(taskService.allTasks());
	    	 taskService.addTask(task);
	    	 return "redirect:/";
	     }
	 }
	
	
	 //Show task info 
	 @RequestMapping("/task/{id}")
	 public String show( Principal principal , Model model,@PathVariable("id") Long id) {
		 
		 String username = principal.getName();
	     model.addAttribute("currentUser", userService.findByUsername(username));
	        
		 Task task = taskService.findTask(id);
		 model.addAttribute("task", task);
		  
	     return "show.jsp";
	 }
	 
	 
	 @RequestMapping("/task/{id}/edit")
	 public String edit(Principal principal , @PathVariable("id") Long id, Model model) {
	     Task task = taskService.findTask(id);
	     model.addAttribute("task", task);
	     List<User> users = userService.allUsers();
	     String username = principal.getName();
	    model.addAttribute("currentUser", userService.findByUsername(username));
	 	model.addAttribute("users" , users );
	     return "edit.jsp";
	 }
	 
	 
	 @RequestMapping(value="/task/edit/{id}", method=RequestMethod.POST)
	 public String update(@Valid @ModelAttribute("task") Task task, BindingResult result) {
	     if (result.hasErrors()) {
	         return "edit.jsp";
	     } else {
	    	 taskService.updateTask(task);
	         return "redirect:/";
	     }
	 }
	 
	
	
    
    

}