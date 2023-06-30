package com.arts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arts.dto.AuthorDTO;
import com.arts.entities.Author;
import com.arts.exception.AuthorException;
import com.arts.service.AuthorService;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {

		this.authorService = authorService;
	}

	@GetMapping
	public List<Author> findAll() {
		List<Author> result = authorService.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public AuthorDTO findById(@PathVariable Long id) {
		return authorService.findBYId(id);
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

	@PutMapping("/{id}")
	public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
		Author result = authorService.updateAuthor(id, author);
		return result;
	}

	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);

	}
}
