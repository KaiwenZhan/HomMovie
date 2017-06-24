package com.cinema.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.business.entities.Movie;
import com.cinema.business.entities.repositories.MovieRepository;

import java.util.List;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService() {
        super();
    }

    public List<Movie> findAll() {
    	return movieRepository.findAll();
    }

    public Movie findById(Integer movieId) {
        return movieRepository.findById(movieId);
    }


    public Movie findByName(String name) {
        return movieRepository.findByName(name);
    }

}
