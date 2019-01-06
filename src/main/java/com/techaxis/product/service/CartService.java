package com.techaxis.product.service;

import com.techaxis.product.model.Cart;

public interface CartService {


	Cart getCartById(int cartId); 
	
	void update(Cart cart); 
}
