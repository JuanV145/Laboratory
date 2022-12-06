package com.laboratory.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "affiliates")
public class Affiliates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Long age;

	@Column(name = "mail")
	private String mail;

	public Affiliates(Long id, String name, Long age, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mail = mail;
	}

	public Affiliates(String name, Long age, String mail) {
		super();
		this.name = name;
		this.age = age;
		this.mail = mail;
	}

	public Affiliates() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
