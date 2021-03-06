package com.goods.spring.mvc.app.service;


import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.goods.spring.mvc.app.dao.CustomerLoginsRepository;
import com.goods.spring.mvc.app.model.CustomerLogins;
import com.goods.spring.mvc.app.model.Customers;
import com.goods.spring.mvc.app.model.Status;
import com.goods.spring.mvc.app.model.Users;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@Service
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
public class CustomerService implements ICustomerService {
	
	@Autowired
	EurekaClient eurekaClient;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public String Customer_Service;
	
	@Value("${microservice.customer-service.endpoints.endpoint.uri}")
	private String CUSTOMER_SERVICE_URL;

	@Value("${microservice.customer-service.endpoints.add.uri}")
	private String ADD_CUSTOMER_OPERATION;
	
	@Value("${microservice.customer-service.endpoints.view.uri}")
	private String VIEW_CUSTOMER_OPERATION;

	public String callShip_Fallback(Users customer) {

		logger.info(Customer_Service+ " Service Unavailable!!");
		return "FAILED";

	}
	
	
	Logger logger = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	com.goods.spring.mvc.app.dao.CustomerRepository customerRespository;

	
	@Autowired
	CustomerLoginsRepository loginRepository;
	
	public CustomerLogins SaveCustomerLogins(CustomerLogins custlogin) {
		return loginRepository.save(custlogin);
	}
	
	//@HystrixCommand(groupKey = "myDash", commandKey = "customer Service", fallbackMethod = "callShip_Fallback")
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

	public Customers getOneCustomerbyEmailID(String emailid) {
		Customers customer=new Customers();
		try {
			customer=customerRespository.findByCustomeremailid(emailid);
		} catch (Exception e) {
			logger.error("Customer-Service: "+e.getMessage());
		}
		
		return customer;
	}

	@HystrixCommand(groupKey = "myDash", commandKey = "customer Service", fallbackMethod = "callShip_Fallback")
	public String AddNewCustomer(Users customer) {
		Customers addedCust=new Customers();
		String response="FAILED";
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			String uri = GetInstanceInfofromEureka() + ADD_CUSTOMER_OPERATION;
			logger.info(Customer_Service+" : calling URL: "+uri);
			HttpEntity<Users> httpEntity = new HttpEntity<>(customer, headers);
			RestTemplate restTemplate = new RestTemplate();
			String str=restTemplate.postForObject(uri, httpEntity, String.class, customer);
			
			logger.info(Customer_Service+" :"+str);

			addedCust=customerRespository.save(saveCustomersInLocalDB(customer));
			BCryptPasswordEncoder encoder=new  BCryptPasswordEncoder();		
			CustomerLogins custlogin=new CustomerLogins();
			custlogin.setCustomer(addedCust);
			custlogin.setCustomerusername(customer.getCustomerusername());
			custlogin.setPassword(encoder.encode(customer.getPassword()));
			CustomerLogins log= SaveCustomerLogins(custlogin);
			response=log.getCustomerusername();
			System.out.println(response);
			response="SUCCESS";
			
		} catch (RestClientException e) {
			logger.error(Customer_Service+" : "+ e.getMessage());
		}
		
		
		return response;
		
	}
	
	private String GetInstanceInfofromEureka() {
		logger.info(Customer_Service+" : Fetching next available instance from eureka discover server");
		InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka(CUSTOMER_SERVICE_URL, false);
		String baseUrl="";
		try {
			baseUrl = nextServerFromEureka.getHomePageUrl();
		} catch (Exception e) {
			logger.error(Customer_Service+" : "+ e.getMessage());
		}
		return baseUrl;
		
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
