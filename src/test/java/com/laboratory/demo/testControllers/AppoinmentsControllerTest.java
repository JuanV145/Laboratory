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

import com.laboratory.demo.controllers.AppoinmentsControllers;
import com.laboratory.demo.entity.Affiliates;
import com.laboratory.demo.entity.Appoinments;
import com.laboratory.demo.entity.dto.AppoinmentsDto;
import com.laboratory.demo.service.impl.AppoinmentsServicesImpl;

@ExtendWith(MockitoExtension.class)
class AppoinmentsControllerTest {

	@InjectMocks
	AppoinmentsControllers appoinmentsControllers = new AppoinmentsControllers();

	@Mock
	AppoinmentsServicesImpl appoinmentsServicesImplMock;

	@Test
	void getListTest() {

		when(appoinmentsServicesImplMock.getlist()).thenReturn(Collections.emptyList());
		var response = appoinmentsControllers.getList();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

	}

	@Test
	void getList2Test() {

		List<Appoinments> appoinments = new ArrayList<Appoinments>();
		appoinments.add(new Appoinments());
		when(appoinmentsServicesImplMock.getlist()).thenReturn(appoinments);
		var response = appoinmentsControllers.getList();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void getByIdTest() {

		when(appoinmentsServicesImplMock.getById(anyLong())).thenReturn(null);
		var response = appoinmentsControllers.getById(anyLong());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void getById2Test() {

		Appoinments appoinments = new Appoinments();
		when(appoinmentsServicesImplMock.getById(anyLong())).thenReturn(Optional.of(appoinments));
		var response = appoinmentsControllers.getById(anyLong());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void postTest() {

		AppoinmentsDto appoinmentsdto = new AppoinmentsDto();
		Appoinments appoinments = new Appoinments();
		when(appoinmentsServicesImplMock.Post(appoinments)).thenReturn(appoinments);
		var response = appoinmentsControllers.Post(appoinmentsdto);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void post2Test() {

		Appoinments appoinments = new Appoinments();
		AppoinmentsDto appoinmentsdto = new AppoinmentsDto();
		when(appoinmentsServicesImplMock.Post(any(Appoinments.class))).thenReturn(appoinments);
		var response = appoinmentsControllers.Post(appoinmentsdto);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	void putTest() {

		var appoinments = new Appoinments();
		when(appoinmentsServicesImplMock.Put(appoinments)).thenReturn(Optional.of(appoinments));
		var response = appoinmentsControllers.Put(appoinments);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	void put2Test() {

		var appoinments = new Appoinments();
		when(appoinmentsServicesImplMock.Put(appoinments)).thenReturn(Optional.empty());
		var response = appoinmentsControllers.Put(appoinments);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	void deleteTest() {

		doThrow(new RuntimeException()).when(appoinmentsServicesImplMock).Delete(anyLong());
		var response = appoinmentsControllers.Delete(anyLong());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

	}

	@Test
	void delete2Test() {

		doNothing().when(appoinmentsServicesImplMock).Delete(anyLong());
		var response = appoinmentsControllers.Delete(anyLong());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void getByDateTest() {

		List<Appoinments> appoinments = new ArrayList<>();
		appoinments.add(new Appoinments());
		when(appoinmentsServicesImplMock.getByDate(any())).thenReturn(appoinments);
		var response = appoinmentsControllers.getByDate(1, 1, 2000);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void getByDate2Test() {

		when(appoinmentsServicesImplMock.getByDate(any())).thenReturn(Collections.emptyList());
		var response = appoinmentsControllers.getByDate(1, 1, 2000);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

	@Test
	void getByAffiliateTest() {
		List<Appoinments> sample = new ArrayList<Appoinments>();
		sample.add(new Appoinments());
		var affiliate = new Affiliates();
		when(appoinmentsServicesImplMock.getByAffiliates(affiliate)).thenReturn(sample);
		var response = appoinmentsControllers.getByAffiliates(affiliate);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void getByAffiliate2Test() {
		var affiliate = new Affiliates();
		when(appoinmentsServicesImplMock.getByAffiliates(affiliate)).thenReturn(Collections.emptyList());
		var response = appoinmentsControllers.getByAffiliates(affiliate);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

}
