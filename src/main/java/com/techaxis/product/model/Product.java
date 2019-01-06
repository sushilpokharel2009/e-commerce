package com.techaxis.product.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
 
 
@Entity
public class Product implements Serializable {
    
	private static final long serialVersionUID = 7352107420022818392L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    
    @NotEmpty(message="The product name must not be null")
    private String productName;
    private String productCategory;
    private String productDescription;
    
    @NotNull(message = "Please enter a valid peoduct price") 
    @Min(value = 0, message = "The product price must not be less than zero")
    private double productPrice;
    
    private String productCondition;
    private String productStatus;
    private String productSize; 
    
    @Min(value = 0, message = "The product unit must not be less than zero")
    private int unitInStock;
    
    private String productManufacturer;
   
    @Transient
    private MultipartFile productImage;
    
    //EAGER means that hibernate will automatically load the cartitemlist
    // when it loads this product object from the DB 
    @OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartitemList; 
    
    public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

	public List<CartItem> getCartitemList() {
		return cartitemList;
	}

	public void setCartitemList(List<CartItem> cartitemList) {
		this.cartitemList = cartitemList;
	}
    
    
}
