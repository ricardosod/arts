package com.arts.converter;

import com.arts.dto.AuthorDTO2;
import com.arts.entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOInput {
    @Autowired
    private ModelMapper modelMapper;

    public Author toEntity(AuthorDTO2 authorDTO2){
        return modelMapper.map(authorDTO2, Author.class);
    }
    public void copyToEntity(AuthorDTO2 authorDTO2, Author author){
         modelMapper.map(authorDTO2, author);
    }
}
