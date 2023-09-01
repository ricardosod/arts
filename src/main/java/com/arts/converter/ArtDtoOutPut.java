package com.arts.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arts.dto.ArtDTO2;
import com.arts.entities.Art;


@Component
public class ArtDtoOutPut {
	
	    @Autowired
	    private ModelMapper modelMapper;

	    public ArtDTO2 toDTO(Art art){
	        return modelMapper.map(art, ArtDTO2.class);
	    }

}
