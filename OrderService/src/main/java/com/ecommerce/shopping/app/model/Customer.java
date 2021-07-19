package com.ecommerce.shopping.app.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid", unique = true, nullable = false)
	private long Customerid;

	public long getCustomerid() {
		return Customerid;
	}

	public void setCustomerid(long customerid) {
		Customerid = customerid;
	}

	@Override
	public String toString() {
		return "Customer [Customerid=" + Customerid + "]";
	}
	
}
