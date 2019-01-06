package com.techaxis.product.dao;

import com.techaxis.product.model.Cart;
import com.techaxis.product.model.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem); 
	
	void removeCartItem(CartItem cartItem); 
	
	void removeAllCartItems(Cart cart); 
	
	CartItem getCartItemByProductId(int productId, int cartId);
}
