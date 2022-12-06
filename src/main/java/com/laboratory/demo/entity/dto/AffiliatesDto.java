package com.laboratory.demo.entity.dto;

public class AffiliatesDto {

	private String name;

	private Long age;

	private String mail;

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

	public AffiliatesDto(String name, Long age, String mail) {
		super();
		this.name = name;
		this.age = age;
		this.mail = mail;
	}

	public AffiliatesDto() {
		super();
	}

}
