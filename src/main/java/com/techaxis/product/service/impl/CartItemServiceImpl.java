package com.techaxis.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techaxis.product.dao.CartItemDao;
import com.techaxis.product.model.Cart;
import com.techaxis.product.model.CartItem;
import com.techaxis.product.service.CartItemService;
 
@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired 
	CartItemDao cartItemDao;
	 

	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem); 
		
	}

	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem); 
		
	}

	public void removeAllCartItems(Cart cart) {
		
		cartItemDao.removeAllCartItems(cart); 
	}

	public CartItem getCartItemByProductId(int productId, int cartId) {
		 
		return cartItemDao.getCartItemByProductId(productId, cartId);
	}

}
