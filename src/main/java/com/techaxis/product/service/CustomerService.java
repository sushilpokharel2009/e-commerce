package com.techaxis.product.service;

import java.util.List;

import com.techaxis.product.model.Customer;

public interface CustomerService {
	
    void addCustomer(Customer customer); 
	
	Customer getCustomerById(int customerId); 
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String userName); 
}
