package com.ecommerce.shopping.app.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="tbl_product")
public class Product  {


	@Id
	private Long idProduct; //column 1
	
		
	private String description; //column 3
	private BigDecimal price; //column 4
	public Long getIdProduct() {
		return idProduct;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", description=" + description + ", price=" + price + "]";
	}
	
	
	
}
