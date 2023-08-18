package com.arts.service;




import java.util.ArrayList;
import java.util.List;



import java.util.Optional;


import com.arts.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


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
		List<Author> result =  authorRepository.findAll();
		return result;
	}


	public AuthorDTO findById(Long id_author){
		Author autor = authorRepository.findById(id_author).get();
		AuthorDTO dto = new AuthorDTO(autor);
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
public Author updateAuthor(Long id, Author author) throws AuthorException {
 Author autorup = authorRepository.findById(id).get();


		autorup.setName(author.getName());
		autorup.setArts(author.getArts());
		autorup.setSex(author.getSex());
		autorup.setBirth(author.getBirth());
		autorup.setCpf(autorup.getCpf());
		autorup.setId(author.getId());
		autorup.setEmail(author.getEmail());

		return  autorup = authorRepository.save(autorup);
}

		/*public Author updateAuthor(Long id, Author author) {
			Author result = authorRepository.findById(id).get();

			result.setName(author.getName());
			result.setId(author.getId());
			result.setEmail(author.getEmail());
			result.setCpf(author.getCpf());
			result.setBirth(author.getBirth());
			result.setArts(author.getArts());
			result.setSex(author.getSex());
			result.setOriginCountry(author.getOriginCountry());

			return result;
		}*/
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


