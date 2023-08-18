package com.arts.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.arts.dto.AuthorDTO2;
import com.arts.service.ArtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arts.dto.AuthorDTO;
import com.arts.entities.Author;
import com.arts.exception.AuthorException;
import com.arts.service.AuthorService;


@Slf4j
@RestController
@RequestMapping(value = "/author")
public class AuthorController {

	private AuthorService authorService;
	private ArtService artService;
	public AuthorController(AuthorService authorService, ArtService artService) {

		this.authorService = authorService;
		this.artService = artService;
	}

	@GetMapping
	public ResponseEntity<List<AuthorDTO>> findAll(@RequestParam(value = "author", defaultValue = "0") Long id_author) {
		List<Author> result = authorService.findAll();
		List<AuthorDTO> dtoList = result.stream().map(x -> new AuthorDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtoList);

	}

	@GetMapping(value = "/{id}")
	public AuthorDTO findById(@PathVariable Long id){
		AuthorDTO result = authorService.findById(id) ;
	return  result;
	}
		@GetMapping(value = "/{id}/art")
	public AuthorDTO findAllArtByAuthorId(@PathVariable Long id){
		AuthorDTO result =authorService.findAllArtByAuthorId(id);
		return result;
	}

	@GetMapping(value = "/{id}/art/{id_art}")
	public AuthorDTO2 findAuthorByIdAndArtId(@PathVariable Long id, @PathVariable Long id_art){
		AuthorDTO2 result = authorService.findAuthorAndArtById(id, id_art);
		log.info("Buscando Autor e Arte por Id , Response: {}, Service: {}", result.toString(), AuthorController.class );
		return  result;
	}


		@PostMapping
	public ResponseEntity<?> insert(@RequestBody Author author) {

		Author authorResposta = null;
		try {
			if (author.getOriginCountry().getId() == null) {
				author.setOriginCountry(authorService.countryExists(author.getOriginCountry().getCountryName()));
			}
			
			authorResposta = authorService.saveAuthor(author);
		} catch (AuthorException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(authorResposta, HttpStatus.CREATED);

	}

	/*@PutMapping("/{id}")
	public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
		Author result = authorService.updateAuthor(id, author);
		return result;
	}*/
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAuthor(@PathVariable Long id, @RequestBody Author author) throws AuthorException {
           Author newauthor = authorService.updateAuthor(id, author);
		   return ResponseEntity.ok().body(new AuthorDTO(newauthor));
	}

	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);

	}
}
