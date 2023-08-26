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

	/*public void setName(String name) {
		this.name = name;
	}*/

	/*public void setEmail(String email) {
		//this.email = email;
	}*/



	private List<ArtDTO> arts;


	/*public void setArts(List<ArtDTO> arts) {
		this.arts = arts;
	}*/

	/*@Override
	public String toString() {
		return "AuthorDTO{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}*/

	/*public String ignoreProperties (AuthorDTO authorDTO) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.serializeAllExcept("arts");
		FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", filter);
		String dtoAsString = objectMapper.writer(filters).writeValueAsString(authorDTO);
		return dtoAsString;
	}*/
}
