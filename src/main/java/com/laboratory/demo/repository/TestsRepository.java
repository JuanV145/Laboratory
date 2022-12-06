package com.laboratory.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.laboratory.demo.entity.Tests;

public interface TestsRepository extends CrudRepository<Tests, Long> {

}
