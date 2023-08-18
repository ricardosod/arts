package com.arts.dto;


import com.arts.entities.Art;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
public class ArtDTO implements Serializable {
    private String name;
    private String description;

    public ArtDTO() {

    }

    public ArtDTO(String name, String description) {

        this.name = name;
        this.description = description;

    }

    public ArtDTO(Art art) {
        name = art.getName();
        description = art.getDescription();

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



    private List<AuthorDTO> author;

    public List<AuthorDTO> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorDTO> author) {
        this.author = author;
    }

   /*@Override
	public String toString() {
		return "ArtDTO{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				//", author=" + author +
				'}';
	}*/
}
