package com.arts.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.arts.dto.ArtDTO2;
import com.arts.entities.Author;
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

import com.arts.dto.ArtDTO;
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
	
	
	//@GetMapping
	//public List<Art> findAll(){
		//List<Art> result = artService.findAll();
		//return result;
		
	//}
	
	@GetMapping
	public ResponseEntity<List<ArtDTO>> findAll(@RequestParam(value = "arte", defaultValue = "0") Long id_art) {
		List<Art> result = artService.findAll();
		List<ArtDTO> dtoList = result.stream().map(x -> new ArtDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtoList);
	}

	@GetMapping(value = "/{id}")
	public ArtDTO findById(@PathVariable Long id){
		ArtDTO result = artService.findById(id);
		return result;
	}

	@GetMapping(value  = "/{id}/author")
	public ArtDTO2 findAllAuthorByArtId(@PathVariable Long id){
		ArtDTO2 result = artService.findAllAuthorByArtId(id);
		return result;

	}
		@GetMapping(value  = "/{id}/author/{id_author}")
	public ArtDTO2 findArtByIdAndAuthorsId(@PathVariable Long id, @PathVariable Long id_author){
		ArtDTO2 result = artService.findArtdAndAuthorId(id, id_author);
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
	public Art update(@PathVariable Long id, @RequestBody Art art, @RequestBody Author author) {
		Art result = artService.updateArt(id, art, author);
		return result;
		
	}
	@DeleteMapping("/{id}")
	public void deleteArt(@PathVariable Long id) {
		artService.deleteArt(id);
		
	}
}
