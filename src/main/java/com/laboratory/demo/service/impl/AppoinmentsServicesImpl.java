package com.laboratory.demo.service.impl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratory.demo.entity.Affiliates;
import com.laboratory.demo.entity.Appoinments;
import com.laboratory.demo.repository.AppoinmentsRepository;
import com.laboratory.demo.service.AppoinmentsService;

@Service
public class AppoinmentsServicesImpl implements AppoinmentsService {

	@Autowired
	private AppoinmentsRepository appoinmentsRepository;

	@Override
	public List<Appoinments> getlist() {

		List<Appoinments> affiliatesDataSource = StreamSupport
				.stream(this.appoinmentsRepository.findAll().spliterator(), false).collect(Collectors.toList());

		return affiliatesDataSource;
	}

	@Override
	public Optional<Appoinments> getById(Long id) {

		Optional<Appoinments> opt = this.appoinmentsRepository.findById(id);

		return opt;

	}

	@Override
	public Appoinments Post(Appoinments appoinments) {

		return this.appoinmentsRepository.save(appoinments);
	}

	@Override
	public Optional<Appoinments> Put(Appoinments appoinments) {

		Optional<Appoinments> opt = appoinmentsRepository.findById(appoinments.getId());
		if (opt.isPresent()) {

			Appoinments update = opt.get();
			update.setDate(appoinments.getDate());
			update.setHour(appoinments.getHour());
			update.setId_test(appoinments.getId_test());
			update.setId_affiliate(appoinments.getId_affiliate());
			appoinmentsRepository.save(update);
			return Optional.ofNullable(update);

		} else {

			return Optional.empty();

		}
	}

	@Override
	public void Delete(Long id) {

		this.appoinmentsRepository.deleteById(id);

	}

	@Override
	public Collection<Appoinments> getByDate(LocalDate date) {

		return appoinmentsRepository.date(date);
	}

	@Override
	public Collection<Appoinments> getByAffiliates(Affiliates id_affiliate) {

		return appoinmentsRepository.getbyaffiliates(id_affiliate);
	}
}
