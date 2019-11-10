package com.wejdan.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wejdan.web.models.Ninja;



public interface NinjaRepositry extends CrudRepository<Ninja , Long> {
	  List<Ninja> findAll();
}
