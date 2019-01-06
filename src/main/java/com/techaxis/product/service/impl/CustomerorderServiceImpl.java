package com.techaxis.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techaxis.product.dao.CustomerOrderDao;
import com.techaxis.product.model.Cart;
import com.techaxis.product.model.CartItem;
import com.techaxis.product.model.CustomerOrder;
import com.techaxis.product.service.CartService;
import com.techaxis.product.service.CustomerOrderService;

@Service
public class CustomerorderServiceImpl implements CustomerOrderService {
	
	@Autowired 
	CustomerOrderDao customerOrderDao; 
	
	@Autowired 
	CartService cartService; 

	public void addCustomerOrder(CustomerOrder customerOrder) {
	 
		customerOrderDao.addCustomerOrder(customerOrder); 

	}

	public double getCustomerOrderGrandTotal(int cartId) {
		double grandTotal = 0; 
		
		Cart cart = cartService.getCartById(cartId); 
		
		List<CartItem> cartItems = cart.getCartItems(); 
		
		for(CartItem item : cartItems) 
		{ 
			grandTotal += item.getTotalPrice(); 
		}
		 
		return grandTotal;
	}

}
