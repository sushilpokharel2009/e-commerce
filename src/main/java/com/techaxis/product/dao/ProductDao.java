package com.techaxis.product.dao;

import java.util.List;

import com.techaxis.product.model.Product;

/**
 * Created by Le on 1/6/2016.
 */
public interface ProductDao {

List<Product> getAllProducts(); 
	
	Product getProductById(int id); 
	
	void addProduct(Product product); 
	
	void editProduct(Product product); 
	
    void deleteProduct(Product product); 
}
