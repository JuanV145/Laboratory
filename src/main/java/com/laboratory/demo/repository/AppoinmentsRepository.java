package com.laboratory.demo.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.laboratory.demo.entity.Affiliates;
import com.laboratory.demo.entity.Appoinments;

public interface AppoinmentsRepository extends CrudRepository<Appoinments, Long> {

	@Query("Select a from Appoinments a Where a.date = :date order by a.id_affiliate")
	public Collection<Appoinments> date(@Param("date") LocalDate date);

	@Query("Select a from Appoinments a Where a.id_affiliate = :id_affiliate")
	public Collection<Appoinments> getbyaffiliates(@Param("id_affiliate") Affiliates id_affiliate);
}
