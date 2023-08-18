package com.arts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import com.arts.entities.Art;
import org.springframework.data.jpa.repository.Query;

public interface ArtRepository extends JpaRepository<Art, Long>{

	Art save(Optional<Art> date);

	@Query(value = "from Art a inner join fetch a.authors au where a.id =?1 and au.id =?2")
	Art findArtByIdAndAuthorsBy_Id(Long id_art, Long author_id);

}
