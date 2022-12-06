package com.laboratory.demo.entity.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppoinmentsDto {

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	@JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime hour;

	private Long id_test;

	private Long id_affiliate;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public Long getId_test() {
		return id_test;
	}

	public void setId_test(Long id_test) {
		this.id_test = id_test;
	}

	public Long getId_affiliate() {
		return id_affiliate;
	}

	public void setId_affiliate(Long id_affiliate) {
		this.id_affiliate = id_affiliate;
	}

	public AppoinmentsDto(LocalDate date, LocalTime hour, Long id_test, Long id_affiliate) {
		super();
		this.date = date;
		this.hour = hour;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}

	public AppoinmentsDto() {
		super();
	}

}
