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

import com.laboratory.demo.controllers.TestsControllers;
import com.laboratory.demo.entity.Tests;
import com.laboratory.demo.entity.dto.TestsDto;
import com.laboratory.demo.service.impl.TestsServicesImpl;

@ExtendWith(MockitoExtension.class)
class TestsControllerTest {

	@InjectMocks
	TestsControllers testsControllers = new TestsControllers();

	@Mock
	TestsServicesImpl testsServicesMock;

	@Test
	void getListTest() {

		when(testsServicesMock.getlist()).thenReturn(Collections.emptyList());
		var response = testsControllers.getList();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

	}

	@Test
	void getList2Test() {

		List<Tests> tests = new ArrayList<Tests>();
		tests.add(new Tests());
		when(testsServicesMock.getlist()).thenReturn(tests);
		var response = testsControllers.getList();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void getByIdTest() {

		when(testsServicesMock.getById(anyLong())).thenReturn(null);
		var response = testsControllers.getById(anyLong());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void getById2Test() {

		Tests test = new Tests();
		when(testsServicesMock.getById(anyLong())).thenReturn(Optional.of(test));
		var response = testsControllers.getById(anyLong());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void postTest() {

		TestsDto testsdto = new TestsDto();
		Tests tests = new Tests();
		when(testsServicesMock.Post(tests)).thenReturn(tests);
		var response = testsControllers.Post(testsdto);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void post2Test() {

		Tests tests = new Tests();
		TestsDto testsdto = new TestsDto();
		when(testsServicesMock.Post(any(Tests.class))).thenReturn(tests);
		var response = testsControllers.Post(testsdto);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	void putTest() {

		Tests tests = new Tests();

		when(testsServicesMock.Put(any(Tests.class))).thenReturn(tests);
		var response = testsControllers.Put(tests);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	void put2Test() {

		Tests tests = new Tests();

		when(testsServicesMock.Put(any(Tests.class))).thenReturn(tests);
		var response = testsControllers.Put(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void deleteTest() {

		doThrow(new RuntimeException()).when(testsServicesMock).Delete(anyLong());
		var response = testsControllers.Delete(anyLong());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

	}

	@Test
	void delete2Test() {

		doNothing().when(testsServicesMock).Delete(anyLong());
		var response = testsControllers.Delete(anyLong());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

}
