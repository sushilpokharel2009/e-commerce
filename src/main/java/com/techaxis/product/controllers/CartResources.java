/* This is our REST SERVICE */ 

package com.techaxis.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.techaxis.product.model.Cart;
import com.techaxis.product.model.CartItem;
import com.techaxis.product.model.Customer;
import com.techaxis.product.model.Product;
import com.techaxis.product.service.CartItemService;
import com.techaxis.product.service.CartService;
import com.techaxis.product.service.CustomerService;
import com.techaxis.product.service.ProductService;


@Controller 
@RequestMapping("/rest/cart")
public class CartResources {
	
	@Autowired 
	CartService cartService; 
	@Autowired
	CustomerService customerService; 
	@Autowired 
	ProductService productService; 
	@Autowired 
	CartItemService cartItemService; 
	
	@RequestMapping("/{cartId}") 
	public @ResponseBody  //this tells spring to convert the Cart object into JSOn format, whihc is made 
	                      //possible by the Jackson dependency 
	Cart getCartById (@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT) 
	@ResponseStatus(value = HttpStatus.NO_CONTENT) 
	public void addItem(@PathVariable int productId, @AuthenticationPrincipal User activeUser){ 
		
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername()); 
		Cart cart = customer.getCart(); 
		Product product = productService.getProductById(productId); 
		List<CartItem> cartItems  = cart.getCartItems(); 
		
		for(int i = 0; i < cartItems.size(); i++)
		{ 
			if(productId == cartItems.get(i).getProduct().getProductId()){ 
				CartItem cartItem  = cartItems.get(i); 
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem); 
				return; 
			}
		}
		
		//Else if the item is new, then do the following 
		CartItem cartItem = new CartItem(); 
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);		
		cartItemService.addCartItem(cartItem); 
	}
	
	@RequestMapping(value = "/remove/{productId}/{cartId}", method = RequestMethod.PUT) 
	@ResponseStatus(value = HttpStatus.NO_CONTENT) 
	public void removeItem(@PathVariable(value = "productId") int productId, @PathVariable(value = "cartId") int cartId){ 
		CartItem cartItem = cartItemService.getCartItemByProductId(productId, cartId); 
		cartItemService.removeCartItem(cartItem); 
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE) 
	@ResponseStatus(value = HttpStatus.NO_CONTENT) 
	public void clearCart(@PathVariable(value = "cartId") int cartId){ 
		Cart cart = cartService.getCartById(cartId); 
		cartItemService.removeAllCartItems(cart);
	}
	
	@RequestMapping(value = "/update/{productId}/{quantity}", method = RequestMethod.PUT) 
	@ResponseStatus(value = HttpStatus.NO_CONTENT) 
	public void updateItem(@PathVariable int productId,@PathVariable int quantity,@AuthenticationPrincipal User activeUser){ 
		
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername()); 
		Cart cart = customer.getCart(); 
		Product product = productService.getProductById(productId); 
		List<CartItem> cartItems  = cart.getCartItems(); 
		
		for(int i = 0; i < cartItems.size(); i++)
		{ 
			if(productId == cartItems.get(i).getProduct().getProductId()){ 
				CartItem cartItem  = cartItems.get(i); 
				cartItem.setQuantity(quantity);
				cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem); 
				return; 
			}
		}
	}
	
	@ExceptionHandler(IllegalArgumentException.class) 
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
	public void handleClientErrors(Exception e) {} 
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal Server Error. ")
	public void handleServerErrors(Exception e) {}
    
}
