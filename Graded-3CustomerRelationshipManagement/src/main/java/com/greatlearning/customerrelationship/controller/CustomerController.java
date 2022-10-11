
package com.greatlearning.customerrelationship.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerrelationship.entity.Customer;
import com.greatlearning.customerrelationship.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	//add mapping for "/List"
	@RequestMapping("/list")
	public String listCustomers(Model theModel)
	{
		System.out.println("request received");

		//get Customers from database
		List<Customer> theCustomers = customerService.findAll();
		//add to the spring model
		theModel.addAttribute("Customer",theCustomers);

		return "menu";
	}


	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomers = new Customer();

		theModel.addAttribute("Customer", theCustomers);

		return "Customer-Form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the Customer from the service
		Customer theCustomers = customerService.findById(theId);

		// set Customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomers);

		// send over to our form
		return "Customer-Form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("FirstName") String FirstName,
			@RequestParam("LastName") String LastName, @RequestParam("Email") String Email) {

		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(FirstName);
			theCustomer.setLastName(LastName);
			theCustomer.setEmail(Email);
		} else
			theCustomer = new Customer(FirstName, LastName, Email);
		// save the Customer
		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		// delete the Customer
		customerService.deleteById(theId);

		// redirect to /customer/list
		return "redirect:/customer/list";

	}

}

