package com.arts.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arts.entities.Art;

public interface ArtRepository extends JpaRepository<Art, Long>{

	Art save(Date date);

}
