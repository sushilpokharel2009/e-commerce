package com.techaxis.product.service;

import java.util.List;

import com.techaxis.product.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts(); 
	
	Product getProductById(int id); 
	
	void addProduct(Product product); 
	
	void editProduct(Product product); 
	
    void deleteProduct(Product product); 
}
