package com.cinema.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cinema.business.entities.User;
import com.cinema.business.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
    public String startLogin(@ModelAttribute("user")User user) {
		return "login";
    }
	
	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute("user")User user) {
		
		return "index";
	}
}
