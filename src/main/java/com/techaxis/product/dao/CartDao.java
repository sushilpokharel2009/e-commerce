package com.techaxis.product.dao;

import java.io.IOException;
import java.util.List;

import com.techaxis.product.model.Cart;
import com.techaxis.product.model.CartItem;

public interface CartDao {

  Cart getCartById(int cartId); 
  void update(Cart cart); 
  Cart validate(int cartId) throws IOException; 
}
