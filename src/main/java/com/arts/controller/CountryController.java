package com.arts.controller;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.arts.dto.CountryDTO;
import com.arts.entities.Author;
import com.arts.entities.Country;
import com.arts.service.CountryService;


@RestController
@RequestMapping("/country")
public class CountryController {


		@Autowired
		private CountryService countryService;
		
		
		//@GetMapping
		//public List<Country> findAll(){
			//List<Country> result = countryService.findAll();
			//return result;
		//}
		
		@GetMapping
		public ResponseEntity<List<CountryDTO>> findAll() {
			List<Country> result = countryService.findAll();
			List<CountryDTO> dtoList = result.stream().map(x -> new CountryDTO(x)).collect(Collectors.toList());
			return ResponseEntity.ok().body(dtoList);
		}

		
		@GetMapping(value = "/{id}")
		public Optional<Country> findByid(@PathVariable Long id) {
			Optional<Country> result = countryService.findById(id);
			return result;
		}
		
		@PostMapping
		public Country  insert(@RequestBody Country  country) {
			Country  result = countryService.saveCountry(country);
			return result;
		}
		    @PutMapping("/{id}")
			public Country updateCountry(@PathVariable Long id, @RequestBody Country country) {
				Country result = countryService.updateCountry(id, country);
				return result;
			}
		    
		    @DeleteMapping("/{id}")
		    public void deleteCountry(@PathVariable Long id) {
		    	 countryService.deleteCountry(id);
		    	
		    	
		    }
	}


