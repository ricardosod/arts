package com.arts.repository;

import com.arts.dto.AuthorDTO2;
import org.springframework.data.jpa.repository.JpaRepository;



import com.arts.entities.Author;
import com.arts.entities.Country;
import org.springframework.data.jpa.repository.Query;


public interface AuthorRepository extends JpaRepository<Author, Long> {

	Country save(Country country);

	@Query(value = "from Author a1 inner join fetch a1.arts a where a1.id =?1 and a.id =?2")
	Author findAuthorByIdAndArts_Id(Long author_id, Long id_art);

}

