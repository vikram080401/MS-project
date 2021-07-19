package com.goods.spring.mvc.app.service;

import java.util.List;

import com.goods.spring.mvc.app.model.Customers;
import com.goods.spring.mvc.app.model.Users;



public interface ICustomerService {
	public List<Customers> getAllCustomer();
	public Customers getOneCustomersbyID(long customerid);
	
	
	
	
	public String AddNewCustomer(Users customer);

}
