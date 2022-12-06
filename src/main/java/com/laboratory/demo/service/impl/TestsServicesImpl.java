package com.laboratory.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.demo.entity.Tests;
import com.laboratory.demo.repository.TestsRepository;
import com.laboratory.demo.service.TestsService;

@Service
public class TestsServicesImpl implements TestsService {

	@Autowired
	private TestsRepository testsRepository;

	@Override
	public List<Tests> getlist() {

		return (List<Tests>) testsRepository.findAll();
	}

	@Override
	public Optional<Tests> getById(Long id) {

		Optional<Tests> opt = this.testsRepository.findById(id);

		return opt;

	}

	@Override
	public Tests Post(Tests tests) {

		return this.testsRepository.save(tests);
	}

	@Override
	public Tests Put(Tests tests) {

		return this.testsRepository.save(tests);
	}

	@Override
	public void Delete(Long id) {

		this.testsRepository.deleteById(id);

	}

}
