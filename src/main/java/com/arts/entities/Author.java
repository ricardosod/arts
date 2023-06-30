package com.arts.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "author")
public class Author implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_author")
	private Long id;
	
	@Column(name = "author_name")
	private String name;
	
	
	@Column(length = 11, unique = true)
	private String cpf;
	
	private String sex;
	

	@Column(unique = true)
	private String email;
	
	
	private Date birth;
	
	
	@ManyToOne
	@JoinColumn(name = "country_origin")
	private Country originCountry;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "art_author",
			joinColumns = {@JoinColumn(name = "art_id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id")})
   @JsonIgnoreProperties(value = "authors")
	private List<Art> arts;
}
	

