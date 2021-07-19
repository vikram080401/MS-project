package com.ecommerce.shopping.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_cartitem")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartitemid", unique = true, nullable = false)
	private int cartitemid;
	
	@Column(name = "itemquantity", nullable = false)
	private int itemquantity;
	
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;
	

	public int getCartitemid() {
		return cartitemid;
	}

	public int getItemquantity() {
		return itemquantity;
	}



	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}

	public void setItemquantity(int itemquantity) {
		this.itemquantity = itemquantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartItem [cartitemid=" + cartitemid + ", itemquantity=" + itemquantity + ", product=" + product + "]";
	}


	
	
}
