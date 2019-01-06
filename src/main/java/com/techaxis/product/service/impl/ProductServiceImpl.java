package com.techaxis.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techaxis.product.dao.ProductDao;
import com.techaxis.product.model.Product;
import com.techaxis.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao; 

	public List<Product> getAllProducts() {
		 
		return productDao.getAllProducts();
	}

	public Product getProductById(int id) {
	
		return productDao.getProductById(id); 
	}

	public void addProduct(Product product) {
		productDao.addProduct(product);

	}

	public void editProduct(Product product) {
		productDao.editProduct(product);

	}

	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);

	}
}
