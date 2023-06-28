package com.arts.service;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arts.dto.AuthorDTO;
import com.arts.entities.Art;
import com.arts.entities.Author;
import com.arts.exception.ArtException;
import com.arts.repository.ArtRepository;


@Service
public class ArtService {

	private ArtRepository artRepository;
    private AuthorService authorService;
	
	public ArtService(ArtRepository artRepository, AuthorService authorService) {
		this.artRepository = artRepository;
		this.authorService = authorService;
	}
	

	public List<Art> findAll(){
		List<Art> result = artRepository.findAll();
		return result;
	}
	
	public Optional<Art> findById(Long id) {
		Optional<Art> result  = artRepository.findById(id);
		return result;
		
	}
	//public Art saveArt(Art art) {
		// art.getName();
		 //return artRepository.save(art);
	
//}
	
	public Art saveArt(Art art) throws ArtException{
		
		
		Art artResponse = null;
         if(verifyDate(art) != null){
        	
			artResponse = artRepository.save(art);
			
		}

	return artResponse;
	}
	 
		public Art verifyDate(Art art) throws ArtException{
		String message =  "A data de Publicação ou de Exposição deve ser informada";
	
	
		 if(art.getDatePublication() == null && art.getDateExposition() != null) {
		
		 }
		
		 
		if(art.getDatePublication() == null && art.getDateExposition()  == null) {
			throw new ArtException(message);
		}
	
		return artRepository.save(art);
		
		}
	
	public Art updateArt(Long id, Art art) {
		Optional<Art> arte = findById(id);
		 arte.get().getName();
		 return artRepository.save(art);
	}
	
	public void deleteArt(Long id) {
		Optional<Art> arted = findById(id);
		arted.get().getId();
		artRepository.deleteById(id);
	}

	public static Date saveArt(Date datePublication) {
	
		return null;
	}

	
}
