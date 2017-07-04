package com.cinema.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.business.entities.Cinema;
import com.cinema.business.entities.repositories.CinemaRepository;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public CinemaService() {
        super();
    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }
    
    public Cinema findById(final Integer id) {
    	return cinemaRepository.findById(id);
    }
    
    public Cinema findByName(final String name) {
    	return cinemaRepository.findByName(name);
    }

    public Cinema findByAddr(final String addr) {
    	return cinemaRepository.findByAddr(addr);
    }
}