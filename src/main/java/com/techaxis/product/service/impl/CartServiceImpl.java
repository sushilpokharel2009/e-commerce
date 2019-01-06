package com.techaxis.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techaxis.product.dao.CartDao;
import com.techaxis.product.model.Cart;
import com.techaxis.product.service.CartService;

@Service
public class CartServiceImpl implements CartService {
		
	@Autowired 
	CartDao cartDao; 

	public Cart getCartById(int cartId) {
		 
		return cartDao.getCartById(cartId);
	}

	public void update(Cart cart) {

		cartDao.update(cart);

	}

}
