package com.laboratory.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.laboratory.demo.entity.Tests;
import com.laboratory.demo.entity.dto.TestsDto;
import com.laboratory.demo.service.TestsService;

@RestController
@RequestMapping("/api/controller/Tests")
public class TestsControllers {

	@Autowired
	private TestsService testsServiceImpl;

	@GetMapping
	@RequestMapping(value = "getList", method = RequestMethod.GET)
	public ResponseEntity<?> getList() {

		List<Tests> consultas = this.testsServiceImpl.getlist();

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
	public ResponseEntity<Tests> getById(@RequestParam Long id) {

		try {

			Optional<Tests> por = testsServiceImpl.getById(id);

			return ResponseEntity.ok(por.get());

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

	@PostMapping
	public ResponseEntity<?> Post(@RequestBody TestsDto testsdto) {

		try {

			Tests nuevoTests = new Tests(testsdto.getName(), testsdto.getDescription());
			this.testsServiceImpl.Post(nuevoTests);

			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

	@PutMapping
	public ResponseEntity<?> Put(@RequestBody Tests tests) {

		try {

			Tests actualizado = this.testsServiceImpl.Put(tests);

			return ResponseEntity.status(HttpStatus.CREATED).body(actualizado);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

	@DeleteMapping
	@RequestMapping(value = "Delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@PathVariable Long id) {

		try {
			this.testsServiceImpl.Delete(id);

			return ResponseEntity.status(HttpStatus.OK).build();

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}

	}

}
