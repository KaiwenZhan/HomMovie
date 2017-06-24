package com.cinema.business.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.business.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>  {
    @Query(value = "select * from User", nativeQuery = true)
    public List<User> findAll();

    @Query(value = "select * from User where UserId = ?1", nativeQuery = true)
    public User findById(final Integer id);

    @Query(value = "select * from User where Phone = ?1", nativeQuery = true)
    public User findByPhone(final String phone);
    
}
