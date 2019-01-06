package com.techaxis.product.model;
import javax.persistence.*; 

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*; 

@Entity 
public class Cart implements Serializable{

	private static final long serialVersionUID = 8926564432068504792L;
	
	@Id 
	@GeneratedValue 
	private int cartId; 
	
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems; 
	
	
	@OneToOne 
	@JoinColumn(name = "customerId")
	@JsonIgnore 
	private Customer customer; 
	
	
	private double grandTotal;


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	} 
}
	
	
	
	
	
	
	
	
	
	
	
//	private String cartId; 
//	 private Map<String, CartItem> cartItems; 
//	 private double grandTotal;
//	 
//	 public Cart(){ 
//		 cartItems = new HashMap<String, CartItem>(); 
//		 grandTotal =0; 
//	 }
//	 
//	 public Cart(String sessionId) { 
//		 this(); 
//		 this.cartId = sessionId; 
//	 } 
//	 
//	public String getCartId() {
//		return cartId;
//	}
//	public void setCartId(String cartId) {
//		this.cartId = cartId;
//	}
//	public Map<String, CartItem> getCartItems() {
//		return cartItems;
//	}
//	public void setCartItems(Map<String, CartItem> cartItems) {
//		this.cartItems = cartItems;
//	}
//	public double getGrandTotal() {
//		return grandTotal;
//	}
//	public void setGrandTotal(double grandTotal) {
//		this.grandTotal = grandTotal;
//	} 
//	
//	public void addCartItem(CartItem item){ 
//		
//		Integer productId = item.getProduct().getProductId();
//		double totalPrice = 0;
//		
//		if(cartItems.containsKey(String.valueOf(productId))){ 
//			
//			CartItem oldItem = cartItems.get(String.valueOf(productId)); 
//			oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
//			totalPrice += oldItem.getQuantity() * oldItem.getProduct().getProductPrice();
//			oldItem.setTotalPrice(totalPrice);
//		}
//		else{
//				cartItems.put(String.valueOf(productId),item); 	
//				item.setTotalPrice(item.getProduct().getProductPrice());
//		}
//		
//		updateTotal(); 
//	}
//	
//    public void updateCartItem(Product product, String quantity){ 
//		
//		Integer productId = product.getProductId();
//		double totalPrice = 0;
//		
//		if(cartItems.containsKey(String.valueOf(productId))){ 
//			
//			CartItem oldItem = cartItems.get(String.valueOf(productId)); 
//			oldItem.setQuantity(Integer.valueOf(quantity));
//			totalPrice += oldItem.getQuantity() * oldItem.getProduct().getProductPrice();
//			oldItem.setTotalPrice(totalPrice);
//		}
//		
//		updateTotal(); 
//	}
//    
//    
//	public void removeCartItem(CartItem item){ 
//		Integer productId = item.getProduct().getProductId();
//		cartItems.remove(String.valueOf(productId)); 
//		
//		updateTotal(); 
//	}
//	
//	
//	private void updateTotal() {
//		// TODO Auto-generated method stub
//		grandTotal = 0; 
//		
//		for(CartItem item: cartItems.values()) 
//		{ 
//			grandTotal +=  item.getTotalPrice(); 
//		}	
//	}
//	 
//}	 
//	 
