package com.ecommerce.shopping.app.service;

import java.util.List;

import com.ecommerce.shopping.app.model.Customers;
import com.ecommerce.shopping.app.model.Users;

public interface ICustomerService {
	public List<Customers> getAllCustomer();
	public Customers getOneCustomersbyID(long customerid);
	public List<Customers> getCustomersbyfirstName(String firstname);
	public Customers getOneCustomerbyEmailID(String emailid);
	public Customers getCustomerbyDOB(String DOB);
	public void DeleACustomer(long customerID);
	public Customers AddNewCustomer(Users customer);

}
