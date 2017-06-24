package com.cinema.business.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id = null;
    private String name = null;
    private String picurl = null;
    private String description = null;
    
    public Movie() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MovieId")
    public Integer getId() {
        return this.id;
    }
    public void setId(final Integer id) {
        this.id = id;
    }

    @Column(name = "MovieName")
    public String getName() {
        return this.name;
    }
    public void setName(final String name) {
        this.name = name;
    }

    @Column(name = "MovieImg")
    public String getPicurl() {
        return this.picurl;
    }
    public void setPicurl(final String picurl) {
        this.picurl = picurl;
    }

    @Column(name = "MovieDesc")
    public String getDescription() {
        return this.description;
    }
    public void setDescription(final String description) {
        this.description = description;
    }
}
