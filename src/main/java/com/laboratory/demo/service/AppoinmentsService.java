package com.laboratory.demo.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.laboratory.demo.entity.Affiliates;
import com.laboratory.demo.entity.Appoinments;

public interface AppoinmentsService {

	List<Appoinments> getlist();

	Optional<Appoinments> getById(Long id);

	Appoinments Post(Appoinments appoinments);

	Optional<Appoinments> Put(Appoinments appoinments);

	void Delete(Long id);

	Collection<Appoinments> getByDate(LocalDate date);

	Collection<Appoinments> getByAffiliates(Affiliates id_affiliate);

}
