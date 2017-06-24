package com.cinema.business.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.business.entities.Movie;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>  {
    @Query(value = "select * from Movie", nativeQuery = true)
    public List<Movie> findAll();

    @Query(value = "select * from Movie where MovieId = ?1", nativeQuery = true)
    public Movie findById(final Integer id);

    @Query(value = "select * from Movie where MovieName = ?1", nativeQuery = true)
    public Movie findByName(final String name);
    
}
