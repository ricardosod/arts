package com.arts.controller;

import java.util.List;
import java.util.Optional;

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

import com.arts.entities.Art;
import com.arts.exception.ArtException;
import com.arts.service.ArtService;

@RestController
@RequestMapping("/art")
public class ArtController {

	private ArtService artService;

	public ArtController(ArtService artService) {
		this.artService = artService;
	}
	
	
	@GetMapping
	public List<Art> findAll(){
		List<Art> result = artService.findAll();
		return result;
		
	}
	
	@GetMapping(value  = "/{id}")
	public Optional<Art> findById(@PathVariable Long id){
		Optional<Art> result = artService.findById(id);
		return result;
		
	}
	
	@PostMapping
     public ResponseEntity<?> insert(@RequestBody Art art) {
		
		Art artResposta = null;
			try {
			if(art.getDatePublication() == null) {
				art.setDatePublication(ArtService.saveArt(art.getDatePublication()));
			}
		        artResposta =  artService.saveArt(art);
			} catch (ArtException e) {
				
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		
			return new ResponseEntity<>(artResposta, HttpStatus.CREATED);
			 
	}
	
	
	@PutMapping(value = "/{id}")
	public Art update(@PathVariable Long id, @RequestBody Art art) {
		Art result = artService.updateArt(id, art);
		return result;
		
	}
	@DeleteMapping("/{id}")
	public void deleteArt(@PathVariable Long id) {
		artService.deleteArt(id);
		
	}
}
