package com.techaxis.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techaxis.product.model.Customer;
import com.techaxis.product.model.Product;
import com.techaxis.product.service.CustomerService;
import com.techaxis.product.service.ProductService;

 

@Controller
@RequestMapping("/admin")
public class AdminHome {
	
	@Autowired 
	ProductService productService; 
	@Autowired 
	CustomerService customerService; 
	
	@RequestMapping 
	public String adminPage(){ 
		return "admin"; 
	}
	
	@RequestMapping("/productInventory") 
	public String productInventory(Model model) { 
		List<Product> products = productService.getAllProducts(); 
		
		model.addAttribute("products", products); 
		
		return "productInventory"; 
	}
	
	@RequestMapping("/customer")
	public String manageCustomers(Model model){ 
		 
		 List<Customer> customerList = customerService.getAllCustomers(); 
		
		 model.addAttribute("customerList", customerList); 
		 
		return "customerManagement"; 
		
	}

}
