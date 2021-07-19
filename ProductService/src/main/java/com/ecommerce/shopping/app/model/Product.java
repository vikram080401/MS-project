package com.ecommerce.shopping.app.model;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;





@Entity
@Table(name = "tblProducts")
public class Product  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idproduct", unique = true, nullable = false)
	private Long idProduct; //column 1
	
	
	@ManyToOne
	@JoinColumn(name = "idcategory")
	private Category category; //column 2
	
	private String description; //column 3
	private BigDecimal price; //column 4
	
	private int availablequantity; //column 5

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", category=" + category + ", description=" + description
				+ ", price=" + price + ", availablequantity=" + availablequantity + "]";
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAvailablequantity() {
		return availablequantity;
	}

	public void setAvailablequantity(int availablequantity) {
		this.availablequantity = availablequantity;
	}


	
}
