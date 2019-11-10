package com.wejdan.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wejdan.web.models.Dojo;

public interface DojoRepositry  extends CrudRepository<Dojo , Long> {
	  List<Dojo> findAll();

}
