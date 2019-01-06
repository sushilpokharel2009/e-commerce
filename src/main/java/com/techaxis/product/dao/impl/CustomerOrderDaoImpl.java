package com.techaxis.product.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techaxis.product.dao.CustomerOrderDao;
import com.techaxis.product.model.CustomerOrder;

@Repository 
@Transactional 
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	
	@Autowired 
	SessionFactory sessionFactory; 
	
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
	 Session session = sessionFactory.getCurrentSession(); 
	 session.saveOrUpdate(customerOrder);
	 session.flush(); 
	}

	 

}
