package com.laboratory.demo.service;

import java.util.List;
import java.util.Optional;
import com.laboratory.demo.entity.Tests;

public interface TestsService {

	List<Tests> getlist();

	Optional<Tests> getById(Long id);

	Tests Post(Tests tests);

	Tests Put(Tests tests);

	void Delete(Long id);

}
