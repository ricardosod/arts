package com.arts.dto;



import java.io.Serializable;

import com.arts.entities.Art;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtDTONoList implements Serializable {
private String name;
	private String description;

	public ArtDTONoList(Object obj) {

	}


	public ArtDTONoList(String name, String description) {

		this.name = name;
		this.description = description;

	}

	public ArtDTONoList(Art art) {
		name = art.getName();
		description = art.getDescription();
		
	}


	
}
