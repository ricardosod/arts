package com.arts.dto;

import com.arts.entities.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

public class AuthorDTO2 implements Serializable {

	private String name;
	private String email;

	public AuthorDTO2() {

	}

	public AuthorDTO2(String name, String email){

		this.name = name;

		this.email = email;

	}

	public AuthorDTO2(Author author) {

		name = author.getName();
		email = author.getEmail();

	}

	public AuthorDTO2(Object obj) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
@JsonIgnoreProperties({"author"})
 private ArtDTO2 art;

	public ArtDTO2 getArt() {
		return art;
	}

	public void setArt(ArtDTO2 art) {
		this.art = art;
	}
	/*@Override
	public String toString() {
		return
				"Name = '" + name + '\'' +
				", Email = '" + email + '\'' +
				'}';
	}*/


}
