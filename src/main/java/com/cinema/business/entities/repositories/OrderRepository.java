package com.cinema.business.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.business.entities.Order;


@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>  {
    @Query(value = "select * from OrderList", nativeQuery = true)
    public List<Order> findAll();

    @Query(value = "select * from OrderList where OrdreId = ?1", nativeQuery = true)
    public Order findById(final Integer id);

    @Query(value = "select * from OrderList where UserId = ?1", nativeQuery = true)
    public List<Order> findByCustomerId(final Integer customerId);
}

