package com.arts.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.arts.dto.AuthorDTONoList;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arts.dto.AuthorDTO;
import com.arts.dto.AuthorDTO2;
import com.arts.entities.Author;
import com.arts.exception.AuthorException;
import com.arts.service.ArtService;
import com.arts.service.AuthorService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


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
	public ResponseEntity<List<AuthorDTONoList>> findAll() {
		List<AuthorDTONoList> result = authorService.findAll();
		return ResponseEntity.ok().body(result);

	}


	@GetMapping(value = "/{id}")
	public AuthorDTONoList findAuthorById(@PathVariable Long id){
		AuthorDTONoList result = authorService.findAuthorById(id);
		log.info("Buscando Autor  por Id , Response: {}, Service: {}", result.toString(), AuthorController.class );
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
		public ResponseEntity<AuthorDTO2> updateAuthorR(@PathVariable Long id, @RequestBody AuthorDTO2 authorDTO2){
	     AuthorDTO2 autor = authorService.updateAuthor(id,authorDTO2);
			return ResponseEntity.ok(autor);

		}

		@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);

	}
}
