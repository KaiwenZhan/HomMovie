package com.cinema.web.controllers;

import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import com.cinema.business.entities.User;
import com.cinema.business.services.UserService;


@Controller
public class SignupController {

	@Autowired
	private UserService userService;

	@GetMapping("/signup")
    public String signupLogin(@ModelAttribute("user")User user) {
		return "signup";
    }
	
	@PostMapping("/signup")
	public String signupSubmit(@ModelAttribute("user")User user) {
		
		return "signup";
	}
}
