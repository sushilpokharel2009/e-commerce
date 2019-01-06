package com.techaxis.product.dao;

import java.io.IOException;
import java.util.List;

import com.techaxis.product.model.Cart;
import com.techaxis.product.model.Customer;

public interface CustomerDao {
	
void addCustomer(Customer customer); 
	
	Customer getCustomerById(int customerId); 
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String userName); 
	
}
