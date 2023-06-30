package com.arts.service;




import java.util.List;



import java.util.Optional;

import org.springframework.stereotype.Service;


import com.arts.dto.AuthorDTO;
import com.arts.entities.Art;
import com.arts.entities.Author;
import com.arts.entities.Country;
import com.arts.exception.AuthorException;
import com.arts.repository.AuthorRepository;


@Service
public class AuthorService {

	
private AuthorRepository authorRepository;
private CountryService countryService;

	public AuthorService(AuthorRepository authorRepository, CountryService countryService) {
	 this.authorRepository = authorRepository;
	 this.countryService = countryService;
}
		
		
		public List<Author> findAll(){
			List<Author> result = authorRepository.findAll();
			return result;
		}
		
		
		public AuthorDTO findBYId(Long id) {
			Author autor = authorRepository.findById(id).get();
			AuthorDTO dto = new AuthorDTO(autor);
			return dto;
		}
		public  Author findById(Long id){
		 	Author result = authorRepository.findById(id).get();
		 	return result;
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
		
		public Author updateAuthor(Long id, Author author) {
			Optional<Author> authorr = authorRepository.findById(id);
			authorr.get().getName();
			
			return authorRepository.save(author);
		}
		

		public void deleteAuthor(Long id) {
			Optional<Author>autord = authorRepository.findById(id);
			autord.get().getId();
			authorRepository.deleteById(id);
			
		}
		
		}

