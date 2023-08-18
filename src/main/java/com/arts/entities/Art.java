package com.arts.entities;

import com.arts.dto.ArtDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
//@Data
@Table(name = "art")
public class Art implements Serializable {

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
	
	

	@ManyToMany(mappedBy = "arts", fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"arts", "originCountry"})
	private List<Author> authors;

	public Art() {
	}

	public Art(Long id, String name, String description, Date datePublication, Date dateExposition, List<Author> authors) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.datePublication = datePublication;
		this.dateExposition = dateExposition;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Date getDateExposition() {
		return dateExposition;
	}

	public void setDateExposition(Date dateExposition) {
		this.dateExposition = dateExposition;
	}


	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


}
	
