package com.wejdan.web.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wejdan.web.models.Task;



public interface TaskRepository extends CrudRepository<Task, Long> , PagingAndSortingRepository<Task, Long> {
	  List<Task> findAll();
	  List<Task> findAllByOrderByPriorityAsc();
	  List<Task> findAllByOrderByPriorityDesc();
	 
}
