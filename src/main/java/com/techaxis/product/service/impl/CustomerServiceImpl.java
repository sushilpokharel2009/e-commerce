package com.techaxis.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techaxis.product.dao.CustomerDao;
import com.techaxis.product.model.Customer;
import com.techaxis.product.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired 
	CustomerDao customerDao; 

	public void addCustomer(Customer customer) {
		 customerDao.addCustomer(customer); 
		
	}

	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(customerId); 
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}
	
	 
	public Customer getCustomerByUsername(String userName) {
		return customerDao.getCustomerByUsername(userName);
	}

}
