package com.arts.dto;

import java.util.Date;

import com.arts.entities.Author;

public class AuthorDTO {

	private Long id;

	private String name;

	private String cpf;

	private String sex;

	private String email;

	private Date birth;

	public AuthorDTO() {

	}

	public AuthorDTO(Long id, String name, String cpf, String sex, String email, Date birth) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.sex = sex;
		this.email = email;
		this.birth = birth;
	}

	public AuthorDTO(Author author) {

		id = author.getId();
		name = author.getName();
		cpf = author.getCpf();
		sex = author.getSex();
		email = author.getEmail();
		birth = author.getBirth();

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
