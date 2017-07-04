package com.cinema.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.business.entities.User;
import com.cinema.business.entities.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
        super();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User findById(final Integer id) {
    	return userRepository.findById(id);
    }
    
    public User findByPhone(final String phone) {
    	return userRepository.findByPhone(phone);
    }
}