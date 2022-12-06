package com.laboratory.demo.testControllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.laboratory.demo.controllers.AffiliatesControllers;
import com.laboratory.demo.entity.Affiliates;
import com.laboratory.demo.entity.dto.AffiliatesDto;
import com.laboratory.demo.service.impl.AffiliatesServicesImpl;

@ExtendWith(MockitoExtension.class)
class AffiliatesControllerTest {

	@InjectMocks
	AffiliatesControllers affiliatesControllers = new AffiliatesControllers();

	@Mock
	AffiliatesServicesImpl affiliatesServicesMock;

	@Test
	void getListTest() {

		when(affiliatesServicesMock.getlist()).thenReturn(Collections.emptyList());
		var response = affiliatesControllers.getList();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

	}

	@Test
	void getList2Test() {

		List<Affiliates> affiliates = new ArrayList<Affiliates>();
		affiliates.add(new Affiliates());
		when(affiliatesServicesMock.getlist()).thenReturn(affiliates);
		var response = affiliatesControllers.getList();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void getByIdTest() {

		when(affiliatesServicesMock.getById(anyLong())).thenReturn(null);
		var response = affiliatesControllers.getById(anyLong());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void getById2Test() {

		Affiliates affiliates = new Affiliates();
		when(affiliatesServicesMock.getById(anyLong())).thenReturn(Optional.of(affiliates));
		var response = affiliatesControllers.getById(anyLong());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void postTest() {

		AffiliatesDto affiliatesdto = new AffiliatesDto();
		Affiliates affiliates = new Affiliates();
		when(affiliatesServicesMock.Post(affiliates)).thenReturn(affiliates);
		var response = affiliatesControllers.Post(affiliatesdto);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void post2Test() {

		Affiliates affiliates = new Affiliates();
		AffiliatesDto affiliatesdto = new AffiliatesDto();
		when(affiliatesServicesMock.Post(any(Affiliates.class))).thenReturn(affiliates);
		var response = affiliatesControllers.Post(affiliatesdto);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	void putTest() {

		Affiliates affiliates = new Affiliates();

		when(affiliatesServicesMock.Put(any(Affiliates.class))).thenReturn(affiliates);
		var response = affiliatesControllers.Put(affiliates);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	void put2Test() {

		Affiliates affiliates = new Affiliates();

		when(affiliatesServicesMock.Put(any(Affiliates.class))).thenReturn(affiliates);
		var response = affiliatesControllers.Put(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void deleteTest() {

		doThrow(new RuntimeException()).when(affiliatesServicesMock).Delete(anyLong());
		var response = affiliatesControllers.Delete(anyLong());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

	}

	@Test
	void delete2Test() {

		doNothing().when(affiliatesServicesMock).Delete(anyLong());
		var response = affiliatesControllers.Delete(anyLong());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

}
