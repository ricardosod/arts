package com.arts.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "art")
public class Art {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_art")
	private Long id;
	
	@Column(name = "art_name")
	private String name;
	
	@Column(name = "art_description")
	private String description;
	
	@Column(name = "date_publication")
	private Date datePublication;
	
	@Column(name = "date_exposition")
	private Date dateExposition;
	
	

	@ManyToMany(mappedBy = "arts")
	private List<Author> authors;


}
	
