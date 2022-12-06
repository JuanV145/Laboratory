package com.laboratory.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.laboratory.demo.entity.Affiliates;
import com.laboratory.demo.entity.dto.AffiliatesDto;
import com.laboratory.demo.service.AffiliatesService;

@RestController
@RequestMapping("/api/controller/Affiliates")
public class AffiliatesControllers {

	@Autowired
	private AffiliatesService affiliatesServiceImpl;

	@GetMapping
	@RequestMapping(value = "getList", method = RequestMethod.GET)
	public ResponseEntity<?> getList() {

		List<Affiliates> consultas = this.affiliatesServiceImpl.getlist();

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
	public ResponseEntity<Affiliates> getById(@RequestParam Long id) {

		try {

			Optional<Affiliates> por = affiliatesServiceImpl.getById(id);

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
	public ResponseEntity<?> Post(@RequestBody AffiliatesDto affiliatesdto) {

		try {

			Affiliates nuevoTests = new Affiliates(affiliatesdto.getName(), affiliatesdto.getAge(),
					affiliatesdto.getMail());
			this.affiliatesServiceImpl.Post(nuevoTests);

			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
	}

	@PutMapping
	public ResponseEntity<?> Put(@RequestBody Affiliates affiliates) {

		try {

			Affiliates actualizado = this.affiliatesServiceImpl.Put(affiliates);

			return ResponseEntity.status(HttpStatus.CREATED).body(actualizado);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
	}

	@DeleteMapping
	@RequestMapping(value = "Delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@PathVariable Long id) {

		try {
			this.affiliatesServiceImpl.Delete(id);

			return ResponseEntity.ok().build();

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}

	}

}
