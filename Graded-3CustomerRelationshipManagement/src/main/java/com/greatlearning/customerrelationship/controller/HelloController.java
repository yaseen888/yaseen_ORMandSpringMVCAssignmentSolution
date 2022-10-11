package com.greatlearning.customerrelationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.customerrelationship.entity.Customer;
import com.greatlearning.customerrelationship.service.CustomerService;


@Controller
public class HelloController {
	@Autowired
	private CustomerService customerService;

	//add mapping for "/List"
	@RequestMapping("/")
	public String listCustomers(Model theModel)
	{
		System.out.println("request received");

		//get Customers from database
		List<Customer> theCustomers = customerService.findAll();
		//add to the spring model
		theModel.addAttribute("Customer",theCustomers);

		return "menu";
	}


}
