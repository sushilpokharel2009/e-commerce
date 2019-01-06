package com.techaxis.product.service;

import com.techaxis.product.model.CustomerOrder;

public interface CustomerOrderService {
	
	void addCustomerOrder(CustomerOrder customerOrder); 
	
	double getCustomerOrderGrandTotal(int cartId); 
	

}
