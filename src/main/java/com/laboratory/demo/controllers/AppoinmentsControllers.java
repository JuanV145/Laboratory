package com.laboratory.demo.controllers;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.laboratory.demo.entity.Affiliates;
import com.laboratory.demo.entity.Appoinments;
import com.laboratory.demo.entity.Tests;
import com.laboratory.demo.entity.dto.AppoinmentsDto;
import com.laboratory.demo.service.AppoinmentsService;

@RestController
@RequestMapping("/api/controller/Appoinments")
public class AppoinmentsControllers {

	@Autowired
	private AppoinmentsService appoinmentsServiceImpl;

	@GetMapping
	@RequestMapping(value = "getList", method = RequestMethod.GET)
	public ResponseEntity<?> getList() {

		List<Appoinments> consultas = this.appoinmentsServiceImpl.getlist();

		try {

			if (consultas.isEmpty()) {

				return ResponseEntity.noContent().build();

			} else {

				return ResponseEntity.ok(consultas);

			}

		} catch (Exception e) {

			return ResponseEntity.noContent().build();

		}

	}

	@GetMapping
	@RequestMapping("/getById")
	public ResponseEntity<Appoinments> getById(@RequestParam Long id) {

		try {

			Optional<Appoinments> por = appoinmentsServiceImpl.getById(id);

			if (por.isPresent()) {

				return ResponseEntity.ok(por.get());

			} else {

				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

			}

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

	@PostMapping
	public ResponseEntity<?> Post(@RequestBody AppoinmentsDto appoinmentsdto) {

		try {

			Tests nuevotests = new Tests();
			Affiliates nuevoAffiliate = new Affiliates();

			nuevotests.setId(appoinmentsdto.getId_test());
			nuevoAffiliate.setId(appoinmentsdto.getId_affiliate());

			Appoinments nuevoTests = new Appoinments(appoinmentsdto.getDate(), appoinmentsdto.getHour(), nuevotests,
					nuevoAffiliate);

			this.appoinmentsServiceImpl.Post(nuevoTests);

			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

	@PutMapping
	public ResponseEntity<?> Put(@RequestBody Appoinments appoinments) {

		try {
			Optional<Appoinments> appoUpdated = this.appoinmentsServiceImpl.Put(appoinments);

			if (appoUpdated.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.status(HttpStatus.CREATED).body(appoUpdated);
			}

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

	@DeleteMapping
	@RequestMapping(value = "Delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@PathVariable Long id) {

		try {

			this.appoinmentsServiceImpl.Delete(id);

			return ResponseEntity.ok().build();

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}

	}

	@GetMapping
	@RequestMapping(value = "getbydate/{day}/{mon}/{year}", method = RequestMethod.GET)
	public ResponseEntity<?> getByDate(@PathVariable int day, @PathVariable int mon, @PathVariable int year) {

		try {
			LocalDate date = LocalDate.of(year, mon, day);
			Collection<Appoinments> appoinments = this.appoinmentsServiceImpl.getByDate(date);

			if (appoinments.isEmpty()) {

				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

			} else {

				return ResponseEntity.ok(appoinments);

			}

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}

	}

	@GetMapping
	@RequestMapping(value = "getByAffiliates/{id_Affiliatte}", method = RequestMethod.GET)
	public ResponseEntity<?> getByAffiliates(@PathVariable Affiliates id_Affiliatte) {

		try {

			Collection<Appoinments> affiliateFound = this.appoinmentsServiceImpl.getByAffiliates(id_Affiliatte);
			if (affiliateFound.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(affiliateFound);
			}

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}
	}

}