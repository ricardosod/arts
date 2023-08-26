package com.arts.service;




import java.util.ArrayList;
import java.util.List;



import java.util.Optional;
import java.util.stream.Collectors;


import com.arts.converter.AuthorDTOInput;
import com.arts.converter.AuthorDtoOutput;
import com.arts.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.arts.entities.Author;
import com.arts.entities.Country;
import com.arts.exception.AuthorException;
import com.arts.repository.AuthorRepository;

@Slf4j
@Service
public class AuthorService {

	
private AuthorRepository authorRepository;
private CountryService countryService;
@Autowired
private AuthorDTOInput authorDTOInput;

	@Autowired
	private AuthorDtoOutput authorDtoOutput;


	public AuthorService(AuthorRepository authorRepository, CountryService countryService) {
	 this.authorRepository = authorRepository;
	 this.countryService = countryService;
	}
		

	public List<AuthorDTONoList> findAll(){
		List<Author> result =  authorRepository.findAll();
		List<AuthorDTONoList> dtoList = result.stream().map(AuthorDTONoList::new).collect(Collectors.toList());
		return dtoList;
	}

		public AuthorDTONoList findAuthorById(Long id){
		Author autor = authorRepository.findById(id).get();
			AuthorDTONoList dto = new AuthorDTONoList(autor);
		return  dto;


	}

	public AuthorDTO2 findAuthorAndArtById(Long id, Long id_art) {
		Author author = authorRepository.findAuthorByIdAndArts_Id(id, id_art);
		AuthorDTO2 authorDTO2 = new AuthorDTO2();
		authorDTO2.setName(author.getName());
		authorDTO2.setEmail(author.getEmail());
		List<ArtDTO2> artes = new ArrayList<>();
		author.getArts().forEach(art -> {
			ArtDTO2 artDTO2 = new ArtDTO2();
			artDTO2.setName(art.getName());
			artDTO2.setDescription(art.getDescription());
			System.out.println("############========" + artDTO2);
			artes.add(artDTO2);
			System.out.println("############" + artes.toString());
		});
		authorDTO2.setArt(artes.get(0));
		return authorDTO2;
	}


	public AuthorDTO findAllArtByAuthorId(Long id) {
		Author result = authorRepository.findById(id).get();
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setName(result.getName());
		authorDTO.setEmail(result.getEmail());
		List<ArtDTO> artes = new ArrayList<>();
		result.getArts().forEach(art -> {
			ArtDTO artDTO= new ArtDTO();
			artDTO.setName(art.getName());
			artDTO.setDescription(art.getDescription());
			System.out.println("###########################" + artDTO);
			artes.add(artDTO);
			System.out.println("############--------------" + artes.toString());
		});
          authorDTO.setArts(artes);
		  return authorDTO;
		//authorDTO2.setArt(artes.get(0));
		//return authorDTO2;
	}
	public Author saveAuthor(Author author) throws AuthorException {
		
			Author authorResponse = null;
			if(verifyCpfCountry(author) != null) {
				authorResponse = authorRepository.save(author);
				
			}

		return authorResponse;
		}

	public Author verifyCpfCountry(Author author) throws AuthorException {
			String message = "O CPF deve ser informado";
			if(author.getOriginCountry().getCountryName().equalsIgnoreCase("Brasil") && (author.getCpf() == null)) {
				throw new AuthorException(message);
				
			}
			 
			if(author.getOriginCountry().getCountryName().equalsIgnoreCase("Brasil") && (author.getCpf().isEmpty() 
					|| author.getCpf().isBlank())) {
				throw new AuthorException(message);
				
			}

			if(!author.getOriginCountry().getCountryName().equalsIgnoreCase("Brasil") 
					&& (author.getCpf() != null) 
					&& (author.getCpf().isEmpty() 
					|| author.getCpf().isBlank())) {
				author.setCpf(null);
				
			}
			return author;
		}
	
		public Country countryExists(String name) {
			Country country = null;
			if(countryService.getCountryByCountryName(name) == null) {
			country = countryService.saveCountry(new Country(name)); 
			}
			if(countryService.getCountryByCountryName(name) != null){
				country = countryService.getCountryByCountryName(name);
				}
			return country;
		}
           public AuthorDTO2 updateAuthor(Long id, AuthorDTO2 authorDTO2){
           Author updateAuthor = authorRepository.findById(id).get();
		   authorDTOInput.copyToEntity(authorDTO2, updateAuthor);
           return authorDtoOutput.toDTO( authorRepository.save(updateAuthor));

	}



		/*public Author updateAuthor(Long id, Author author) {
			Optional<Author> authorr = authorRepository.findById(id);
			authorr.get().getName();
			return authorRepository.save(author);
		}*/



		public void deleteAuthor(Long id) {
			Optional<Author>autord = authorRepository.findById(id);
			autord.get().getId();
			authorRepository.deleteById(id);
			
		}




}


