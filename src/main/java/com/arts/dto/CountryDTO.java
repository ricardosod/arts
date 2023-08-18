package com.arts.dto;

import java.io.Serializable;
import java.util.List;

import com.arts.entities.Country;

public class CountryDTO implements Serializable{

    
	private String countryName;

    public CountryDTO() {
    }

   
    

	public CountryDTO(String countryName) {

		this.countryName = countryName;
	}

	public CountryDTO(Country country) {
		countryName = country.getCountryName();

	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


}
