package com.laboratory.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "appoinments")
public class Appoinments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date")
	private LocalDate date;

	@JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "hour")
	private LocalTime hour;

	@JoinColumn(name = "id_test")
	@ManyToOne
	private Tests id_test;

	@JoinColumn(name = "id_affiliate")
	@ManyToOne
	private Affiliates id_affiliate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Tests getId_test() {
		return id_test;
	}

	public void setId_test(Tests id_test) {
		this.id_test = id_test;
	}

	public Affiliates getId_affiliate() {
		return id_affiliate;
	}

	public void setId_affiliate(Affiliates id_affiliate) {
		this.id_affiliate = id_affiliate;
	}

	public Appoinments(Long id, LocalDate date, LocalTime hour, Tests id_test, Affiliates id_affiliate) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}

	public Appoinments(LocalDate date, LocalTime hour, Tests id_test, Affiliates id_affiliate) {
		super();
		this.date = date;
		this.hour = hour;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}

	public Appoinments() {
		super();
	}

}
