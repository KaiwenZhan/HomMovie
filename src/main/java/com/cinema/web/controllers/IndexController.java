package com.cinema.web.controllers;

import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import com.cinema.business.entities.User;
import com.cinema.business.services.MovieService;
import com.cinema.business.services.UserService;


@Controller
public class IndexController {

    @RequestMapping("/login")
    String login() {
        return  "login";
    }
    
    @RequestMapping("/signin")
    String signin() {
        return  "signin";
    }
    
    @RequestMapping("/order")
    String order() {
        return  "order";
    }
    
    @RequestMapping("/error")
    String error() {
        return  "error";
    }

    @RequestMapping("/signup")
    String signup() {
        return  "signup";
    }
    @Autowired
	private MovieService  movieService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute()
	@RequestMapping(value = "/index")
    public String IndexPage(ModelMap model, HttpSession session) {
        Object object = session.getAttribute("user");
        if (object != null) {
        	session.invalidate();
        	model.addAttribute("url", "/loginout");
            model.addAttribute("status", "登出");
            System.out.println("loginout");
        }
        else {
        	model.addAttribute("url", "/login");
            model.addAttribute("status", "登录");
            System.out.println("login");
		}
        
        return "index";
    }
    
    @RequestMapping(value = "/index",  method = RequestMethod.POST) 
    public String IndexPage(@ModelAttribute("user")User user, ModelMap model) {
    	System.out.println("index");
    	String _name = user.getName();
    	String _pass = user.getPassword();
    	
    	System.out.println(_name);
    	System.out.println(_pass);
    	UsernamePasswordToken token = new UsernamePasswordToken(_name, _pass);
    	token.setRememberMe(true);
    	Subject subject = SecurityUtils.getSubject();
    	try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				System.out.println("OK");
				return "index";
			}
			else {
				System.out.println("No");
				return "login";
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
    	
    	return "login";
    }
}
