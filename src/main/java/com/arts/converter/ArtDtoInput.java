package com.arts.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arts.dto.ArtDTO2;
import com.arts.entities.Art;

@Component
public class ArtDtoInput {
	
	@Autowired
	private ModelMapper modelMapper;

	public Art toEntity(ArtDTO2 artDTO2) {
		return modelMapper.map(artDTO2, Art.class);
	}

	public void copyToEntity(ArtDTO2 artDTO2, Art art) {
		modelMapper.map(artDTO2, art);
	}
}
