package com.cinema.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinema.business.entities.Cinema;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Integer> {
    @Query(value = "select * from Cinema", nativeQuery = true)
    public List<Cinema> findAll();

    @Query(value = "select * from Cinema where CinemaId = ?1", nativeQuery = true)
    public Cinema findById(final Integer id);

    @Query(value = "select * from Cinema where CinemaName = ?1", nativeQuery = true)
    public Cinema findByName(final String name);

    @Query(value = "select * from Cinema where CinemaAddress like ?1", nativeQuery = true)
    public Cinema findByAddr(final String addr);
    
}
