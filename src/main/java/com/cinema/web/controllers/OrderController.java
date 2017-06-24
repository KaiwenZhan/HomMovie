package com.cinema.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinema.business.entities.Order;
import com.cinema.business.services.MovieService;
import com.cinema.business.services.OrderService;


@Controller

public class OrderController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/order", method = RequestMethod.POST)
    public String finishOrderTicket(final ModelMap model, @ModelAttribute("order") Order order, final BindingResult bindingResult ) {
    	model.clear();
		if (bindingResult.hasErrors()) {
    		return "redirect:/ticket";
    	}

        System.out.println(order.getId());


        return "order";
    }

	@RequestMapping("order/{orderId}")
	public String orderDetail(@PathVariable("orderId")String orderId) {
		return	"order";
	}
}
