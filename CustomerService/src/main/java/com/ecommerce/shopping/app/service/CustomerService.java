package com.ecommerce.shopping.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ecommerce.shopping.app.dao.CustomerLoginsRepository;
import com.ecommerce.shopping.app.dao.CustomerLoyalityRepository;
import com.ecommerce.shopping.app.dao.CustomerRepository;
import com.ecommerce.shopping.app.model.CustomerLogins;
import com.ecommerce.shopping.app.model.Customers;
import com.ecommerce.shopping.app.model.Status;
import com.ecommerce.shopping.app.model.Users;


@Service
public class CustomerService implements ICustomerService {
	Logger logger = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	CustomerRepository customerRespository;
	
	@Autowired
	CustomerLoyalityRepository loyalityRepository;
	
	@Autowired
	CustomerLoginsRepository loginRepository;
	
	public CustomerLogins SaveCustomerLogins(CustomerLogins custlogin) {
		return loginRepository.save(custlogin);
	}
	
	public List<Customers> getAllCustomer(){
		List<Customers> allCustomerList =Collections.emptyList();
		try {		
			 allCustomerList= (List<Customers>) customerRespository.findAll();
			 logger.info("Customer-Service: Returned all customers from database");
		} catch (Exception e) {
			
			logger.error("Customer-Service: "+e.getMessage());
		}
		return allCustomerList;
	}
	public Customers getOneCustomersbyID(long customerid) {
		Customers customer=new Customers();
		try {
			customer=customerRespository.findById(customerid).orElse(null);
			logger.info("Customer-Service: Returned customer from database");
		} catch (Exception e) {
			logger.error("Customer-Service: "+e.getMessage());
		}
		
		return  customer;
	}
	public List<Customers> getCustomersbyfirstName(String firstname){
		List<Customers> likeList=new ArrayList<>();
		try {
			likeList=customerRespository.findByFirstname(firstname);
		} catch (Exception e) {
			logger.error("Customer-Service: "+e.getMessage());
		}
		
		return likeList;
	}
	public Customers getOneCustomerbyEmailID(String emailid) {
		Customers customer=new Customers();
		try {
			customer=customerRespository.findByCustomeremailid(emailid);
		} catch (Exception e) {
			logger.error("Customer-Service: "+e.getMessage());
		}
		
		return customer;
	}
	public Customers getCustomerbyDOB(String DOB) {
		Customers customer=new Customers();
		try {
			customer=customerRespository.findByDateofbirth(DOB);
		} catch (Exception e) {
			logger.error("Customer-Service: "+e.getMessage());
		}
		return customer;
	}
	public void DeleACustomer(long customerID) {
		customerRespository.deleteById(customerID);
	}
	public Customers AddNewCustomer(Users customer) {
		Customers addedCust=new Customers();
		
		
		addedCust=customerRespository.save(saveCustomersInLocalDB(customer));
		
		BCryptPasswordEncoder encoder=new  BCryptPasswordEncoder();		
		CustomerLogins custlogin=new CustomerLogins();
		custlogin.setCustomer(addedCust);
		custlogin.setCustomerusername(customer.getCustomerusername());
		custlogin.setPassword(encoder.encode(customer.getPassword()));
		SaveCustomerLogins(custlogin);
		
		return addedCust;
		
	}
	private Customers saveCustomersInLocalDB(Users user) {
		Customers customer= new Customers();
		customer.setCustomeremailid(user.getCustomeremailid());
		customer.setFirstname(user.getFirstname());
		customer.setLastname(user.getLastname());
		customer.setDateofbirth(user.getDateofbirth());
		customer.setContactnumber(user.getContactnumber());
		customer.setAddressLine1(user.getAddressLine1());
		customer.setAddressLine2(user.getAddressLine2());
		customer.setZipcode(user.getZipcode());
		customer.setState(user.getState());
		customer.setCity(user.getCity());
		customer.setSecretquestion(user.getSecretquestion());
		customer.setSecretquestionanswer(user.getSecretquestionanswer());
		customer.setStatus(Status.ACTIVE);
		return customer;
	}
}
