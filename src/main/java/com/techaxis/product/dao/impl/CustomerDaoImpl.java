package com.techaxis.product.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techaxis.product.dao.CustomerDao;
import com.techaxis.product.model.Authorities;
import com.techaxis.product.model.Cart;
import com.techaxis.product.model.Customer;
import com.techaxis.product.model.Users;


@Repository 
@Transactional 
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired 
	private SessionFactory sessionFactory;

	public void addCustomer(Customer customer) {
		 Session session = sessionFactory.getCurrentSession(); 
		 
		//Although the cutomer object has the billing ans shiupping addresses, these two classes however do not 
		 // have customer data. In order to mimic the DB, we need to set the customer object in these classes explicitly 
		 // so that in the DB, you can see customerId in these two tables. 
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		 
		 session.saveOrUpdate(customer);
		 session.saveOrUpdate(customer.getBillingAddress());
		 session.saveOrUpdate(customer.getShippingAddress());
		 
		 
		 //Create this customer in users table 
		 Users newUser = new Users(); 
		 newUser.setUserName(customer.getUserName());
		 newUser.setPassword(customer.getPassword());
		 newUser.setEnabled(true);
		 newUser.setCustomerId(customer.getCustomerId());
		 
		 //Create authority for this user
		 Authorities newAuthority = new Authorities(); 
		 newAuthority.setUsername(customer.getUserName());
		 newAuthority.setAuthority("ROLE_USER");
		 session.saveOrUpdate(newUser);
		 session.saveOrUpdate(newAuthority);
		 
		 Cart newCart = new Cart(); 
		 newCart.setCustomer(customer);
		 customer.setCart(newCart);
		 session.saveOrUpdate(customer);
		 session.saveOrUpdate(newCart);
		 
		 session.flush();
	}

	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession(); 
		
		return (Customer) session.get(Customer.class, customerId);
	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession(); 
		Query query = session.createQuery("from Customer"); 
		List<Customer> customerList = query.list();
		return customerList; 
	}

	public Customer getCustomerByUsername(String userName) {
		Session session = sessionFactory.getCurrentSession(); 
		Query query = session.createQuery("from Customer where username = ?"); 
		
		query.setString(0,userName); 
		return (Customer) query.uniqueResult(); 
		
		//return (Customer) session.get(Customer.class, userName);
		
	} 
	
	
}
