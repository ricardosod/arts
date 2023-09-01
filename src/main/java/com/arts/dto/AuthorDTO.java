package com.arts.dto;

import java.io.Serializable;
import java.util.List;

import com.arts.entities.Author;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonFilter("myFilter")
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

	@JsonIgnoreProperties({"author"})
	private List<ArtDTO> arts;


	
}
