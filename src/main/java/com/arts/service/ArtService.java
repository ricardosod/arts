package com.arts.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.arts.dto.ArtDTO;
import com.arts.dto.ArtDTO2;
import com.arts.dto.AuthorDTO;
import com.arts.dto.AuthorDTO2;
import com.arts.entities.Author;
import org.springframework.stereotype.Service;

import com.arts.entities.Art;
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
	
	/*public Optional<Art> findById(Long id_art) {
		Optional<Art> result  = artRepository.findById(id_art);
		return result;

	}*/
	public ArtDTO findById(Long id_art){
		Art arte = artRepository.findById(id_art).get();
		ArtDTO dto = new ArtDTO(arte);
		return dto;
	}
		public  ArtDTO2 findArtdAndAuthorId(Long id, Long id_author){
		Art artte = artRepository.findArtByIdAndAuthorsBy_Id(id, id_author);
		ArtDTO2 artDTO2 = new ArtDTO2();
		artDTO2.setName(artte.getName());
		artDTO2.setDescription(artte.getDescription());
		List<AuthorDTO2> autor = new ArrayList<>();
		artte.getAuthors().forEach(author -> {
			AuthorDTO2 authorDTO2 = new AuthorDTO2();
			authorDTO2.setName(author.getName());
			authorDTO2.setEmail(author.getEmail());
			System.out.println("++++++++++++++++++++++++++++++++++++++++" + authorDTO2);
			autor.add(authorDTO2);
			System.out.println("========================================" + autor.toString());
		});
		artDTO2.setAuthor(autor.get(0));
		return  artDTO2;
	}

        public ArtDTO2 findAllAuthorByArtId(Long id){

		Art result = artRepository.findById(id).get();
		ArtDTO2 artDTO2 = new ArtDTO2();
		artDTO2.setName(result.getName());
		artDTO2.setDescription(result.getDescription());
		List<AuthorDTO2> autor = new ArrayList<>();
		result.getAuthors().forEach(author -> {
			AuthorDTO2 authorDTO2 = new AuthorDTO2();
			authorDTO2.setName(author.getName());
			authorDTO2.setEmail(author.getEmail());
			System.out.println("++++++++++++++++++++++++" + authorDTO2);
			autor.add(authorDTO2);
			System.out.println("-------------------------" + autor.toString());
		});
			artDTO2.setAuthor(autor.get(0));
		    return artDTO2;
		}

	public Art saveArt(Art art) throws ArtException {
		Art artResponse = null;
		if (verifyDate(art) != null) {

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
	
	public Art updateArt(Long id, Art art, Author author) {
	Optional<Art> arte = artRepository.findById(id);
		 arte.get().getName();
		 return artRepository.save(arte);
	}

	public void deleteArt(Long id) {
	Optional<Art> arted = artRepository.findById(id);
		arted.get().getId();
		artRepository.deleteById(id);
	}


	public static Date saveArt(Date datePublication) {
	
		return null;
	}



}
