package com.arts.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "country")
public class Country {

	

	public Country() {
		
	}

	
	public Country(String countryName) {
		
		this.countryName = countryName;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_country")
	private Long id;
	
	@Column(name = "country_name")
	private String countryName;

	


	
	

	
	
	

	
	
}

