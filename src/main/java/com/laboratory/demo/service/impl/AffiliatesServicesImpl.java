package com.laboratory.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.demo.entity.Affiliates;
import com.laboratory.demo.repository.AffiliatesRepository;
import com.laboratory.demo.service.AffiliatesService;

@Service
public class AffiliatesServicesImpl implements AffiliatesService {

	@Autowired
	private AffiliatesRepository affiliatesRepository;

	@Override
	public List<Affiliates> getlist() {

		List<Affiliates> affiliatesDataSource = StreamSupport
				.stream(this.affiliatesRepository.findAll().spliterator(), false).collect(Collectors.toList());

		return affiliatesDataSource;
	}

	@Override
	public Optional<Affiliates> getById(Long id) {

		Optional<Affiliates> opt = this.affiliatesRepository.findById(id);

		return opt;

	}

	@Override
	public Affiliates Post(Affiliates affiliates) {

		return this.affiliatesRepository.save(affiliates);
	}

	@Override
	public Affiliates Put(Affiliates affiliates) {

		return this.affiliatesRepository.save(affiliates);
	}

	@Override
	public void Delete(Long id) {

		this.affiliatesRepository.deleteById(id);

	}

}
