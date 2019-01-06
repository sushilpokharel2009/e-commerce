package com.techaxis.product.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techaxis.product.dao.CartDao;
import com.techaxis.product.model.Cart;
import com.techaxis.product.model.CartItem;
import com.techaxis.product.service.CustomerOrderService;


@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	
	@Autowired 
	private SessionFactory sessionFactory; 
	
	@Autowired 
	CustomerOrderService customerOrderService; 

	public Cart getCartById(int cartId) {
		Session session = sessionFactory.getCurrentSession(); 
		return (Cart) session.get(Cart.class,  cartId); 
	}

	public void update(Cart cart) {
		int cartId = cart.getCartId(); 
		
		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId); 
		
		cart.setGrandTotal(grandTotal);
		
	     Session session = sessionFactory.getCurrentSession(); 
	     
	     session.saveOrUpdate(cart);
		
	}

	public Cart validate(int cartId) throws IOException {
	 Cart cart = getCartById(cartId); 
	 
	 if(cart == null || cart.getCartItems().size() == 0){ 
		 throw new IOException(cartId + "" ); 
	 }
	 
	 update(cart);
		return cart; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private HashMap<String, Cart> listOfCarts; 
//public CartDaoImpl(){ 
	//listOfCarts = new HashMap<String,Cart>(); 
//}
//	public Cart create(Cart cart) {
//		if(listOfCarts.keySet().contains(cart.getCartId())){ 
//			throw new IllegalArgumentException(String.format("Cannot Create Cart: A cart with the given id(%) already exist!", cart.getCartId()));
//		}
//
//        listOfCarts.put(String.valueOf(cart.getCartId()), cart); 
//        
//        return cart;
//	}
//
//	public Cart read(String cartId) {
//		 
//		return listOfCarts.get(cartId); 
//	}
//
//	public void update(String cartId, Cart cart) {
//		if(!listOfCarts.keySet().contains(cart.getCartId())){ 
//			throw new IllegalArgumentException(String.format("Cannot Update Cart: A cart with the given id(%) does not exist!", cart.getCartId()));
//		}
//		
//		listOfCarts.put(cartId, cart); 
//		
//	}
//
//	public void delete(String cartId) {
//		if(!listOfCarts.keySet().contains(cartId)){ 
//			throw new IllegalArgumentException(String.format("Cannot Delete Cart: A cart with the given id(%) does not exist!", cartId));
//		}
//		
//		listOfCarts.remove(cartId); 
//		
//	}

}
