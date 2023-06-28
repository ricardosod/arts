package com.arts.service;

import java.util.List;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arts.entities.Country;
import com.arts.repository.CountryRepository;


@Service
public class CountryService {

	
	private CountryRepository countryRepository;
	
	public CountryService(CountryRepository countryRepository) {
	
		this.countryRepository = countryRepository;
	}
	
	
	public List<Country> findAll(){
		List<Country> result = countryRepository.findAll();
		return result;
	}
	public  Optional<Country> findById(Long id){
	 	Optional<Country> result = countryRepository.findById(id);
	 	return result;
	}
	

	public Country saveCountry(Country country) {
		country.getCountryName();
		return countryRepository.save(country);
	}
	public Country updateCountry(Long id, Country country) {
		Optional<Country> countryy = findById(id);
		countryy.get().getCountryName();
		
		return countryRepository.save(country);
	}
	
	public void deleteCountry(Long id) {
		countryRepository.deleteById(id);
		
	}
	public Country getCountryByCountryName(String countryName) {
		return countryRepository.findCountryByCountryName(countryName);
		
	}
	
	}
	
	

