package com.laboratory.demo.service;

import java.util.List;
import java.util.Optional;
import com.laboratory.demo.entity.Affiliates;

public interface AffiliatesService {

	List<Affiliates> getlist();

	Optional<Affiliates> getById(Long id);

	Affiliates Post(Affiliates tests);

	Affiliates Put(Affiliates tests);

	void Delete(Long id);

}
