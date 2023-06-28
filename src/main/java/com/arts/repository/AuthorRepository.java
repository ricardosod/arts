package com.arts.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.arts.entities.Author;
import com.arts.entities.Country;



public interface AuthorRepository extends JpaRepository<Author, Long>{

	Country save(Country country);

	

	

	
}
