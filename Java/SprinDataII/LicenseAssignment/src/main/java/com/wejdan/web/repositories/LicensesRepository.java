package com.wejdan.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wejdan.web.models.License;

public interface LicensesRepository extends CrudRepository<License , Long> {
	  List<License> findAll();

}
