package com.greatlearning.customerrelationship.service;

import java.util.List;

import com.greatlearning.customerrelationship.entity.Customer;


public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);

	public void print(List<Customer> customer);

}
