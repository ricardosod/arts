package com.arts.dto;

import com.arts.entities.Author;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter

public class AuthorDTONoList implements Serializable {

	private String name;
	private String email;

	public AuthorDTONoList() {
	}
	public AuthorDTONoList(String name, String email){

		this.name = name;

		this.email = email;
	}

	public AuthorDTONoList(Author author) {

		name = author.getName();
		email = author.getEmail();
	}
	public AuthorDTONoList(Object obj) {
	}


}
