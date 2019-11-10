package com.wejdan.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wejdan.web.models.Person;

public interface PersonRepository extends CrudRepository<Person , Long> {
	  List<Person> findAll();

}
