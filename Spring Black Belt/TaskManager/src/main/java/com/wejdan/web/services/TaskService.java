package com.wejdan.web.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wejdan.web.models.Task;
import com.wejdan.web.repositories.TaskRepository;



@Service
public class TaskService {
	
private final TaskRepository taskRepo;
	
	public TaskService(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
		
	}
	
	public List<Task> allTasks() {
        return taskRepo.findAll();
    }

	public List<Task> allTasksAsc() {
        return taskRepo.findAllByOrderByPriorityAsc();
    }
    
    public List<Task> allTasksDesc() {
        return taskRepo.findAllByOrderByPriorityDesc();
    }
   
	
	
	//add  
	  public Task addTask(Task task) {
	        return taskRepo.save(task);
	    }
	  
	  //remove  
	   public void removeTask(Long id) {
		   taskRepo.deleteById(id);
       }
	   
	
	    public Task findTask(Long id) {
	        Optional<Task> optionalTask = taskRepo.findById(id);
	        if(optionalTask.isPresent()) {
	            return optionalTask.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Task updateTask(Task t) {
	        return taskRepo.save(t);
	    }
	    

}
