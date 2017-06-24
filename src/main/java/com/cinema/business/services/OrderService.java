package com.cinema.business.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cinema.business.entities.Order;
import com.cinema.business.entities.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public OrderService() {
        super();
    }
    
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(final Integer id) {
        return orderRepository.findById(id);
    }

    public List<Order> findByCustomerId(final Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}
