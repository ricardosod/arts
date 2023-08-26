package com.arts.converter;

import com.arts.dto.AuthorDTO2;
import com.arts.entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthorDtoOutput {
    @Autowired
    private ModelMapper modelMapper;

    public AuthorDTO2 toDTO(Author author){
        return modelMapper.map(author, AuthorDTO2.class);
    }

}
