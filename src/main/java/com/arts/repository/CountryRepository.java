package com.arts.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.arts.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

	public Country findCountryByCountryName(String countryName);

}
