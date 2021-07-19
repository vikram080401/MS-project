package com.ecommerce.shopping.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customerlogins")
public class CustomerLogins {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerloginid", unique = true, nullable = false)
	private long CustomerLoginID; //PK tbl_customerlogins
	
	@Column(name="customrusername", nullable = false)
	private String customerusername;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@OneToOne
	@JoinColumn(name = "customerid")
	private Customers customer; //FK table tbl_customers

	public long getCustomerLoginID() {
		return CustomerLoginID;
	}

	public void setCustomerLoginID(long customerLoginID) {
		CustomerLoginID = customerLoginID;
	}

	public String getCustomerusername() {
		return customerusername;
	}

	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
}
