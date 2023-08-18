package com.arts.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.arts.entities.Art;
import com.arts.entities.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class AuthorDTO  implements Serializable {

	private String name;
	private String email;

	public AuthorDTO() {

	}

	public AuthorDTO(String name, String email){

		this.name = name;

		this.email = email;

	}

	public AuthorDTO(Author author) {

		name = author.getName();
		email = author.getEmail();

	}

	public AuthorDTO(Object obj) {
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
	private List<ArtDTO> arts;

	public List<ArtDTO> getArts() {
		return arts;
	}

	public void setArts(List<ArtDTO> arts) {
		this.arts = arts;
	}

	/*@Override
	public String toString() {
		return "AuthorDTO{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}*/

}