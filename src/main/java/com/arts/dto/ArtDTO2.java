package com.arts.dto;



import com.arts.entities.Art;

import java.io.Serializable;
import java.util.List;


public class ArtDTO2 implements Serializable {
private String name;
	private String description;

	public ArtDTO2() {

	}


	public ArtDTO2(String name, String description) {

		this.name = name;
		this.description = description;

	}

	public ArtDTO2(Art art) {
		name = art.getName();
		description = art.getDescription();
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
      private AuthorDTO2 author;

	public AuthorDTO2 getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO2 author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Art{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}


}
