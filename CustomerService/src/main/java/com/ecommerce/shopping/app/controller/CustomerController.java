package com.ecommerce.shopping.app.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ecommerce.shopping.app.model.Customers;

import com.ecommerce.shopping.app.model.Users;
import com.ecommerce.shopping.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/view")
	public List<Customers> ViewAllCustoemrs(){
		return customerService.getAllCustomer();
		
	}
	
	@PostMapping("/addcustomer")
	public Customers AddNewCustomer(@RequestBody Users customer) {
		return customerService.AddNewCustomer(customer);
				
		
	}

}
