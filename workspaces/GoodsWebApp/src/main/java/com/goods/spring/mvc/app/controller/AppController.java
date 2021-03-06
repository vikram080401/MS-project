package com.goods.spring.mvc.app.controller;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.goods.spring.mvc.app.model.Customers;

import com.goods.spring.mvc.app.model.Users;
import com.goods.spring.mvc.app.service.CustomerService;

import java.security.Principal;
import java.util.*;

@Controller
public class AppController {

	@Autowired
	CustomerService custSrvice;
	
	 @GetMapping("/login")
	    public Map<String, Object> user(@AuthenticationPrincipal Principal principal) {
	        return Collections.singletonMap("name", principal.getName());
	    }
	@GetMapping("")
	public String viewHomePage() {
		return "home";
		
	}
	
	@GetMapping("/list_users")
	public String ViewUsersList() {
		return "user";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
	    List<Customers> listUsers = custSrvice.getAllCustomer();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
	
	@GetMapping("/register")
	public String ShowSignUpForm(Model model) {
		model.addAttribute("user", new Users());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String Completeregistration(Users user) {

		String response= custSrvice.AddNewCustomer(user);
		System.out.println(response);
		if(response!="SUCCESS") {
			System.out.println("It means failed");
			return "failed";
			
		}
System.out.println("wait");
		return "registered";
	}
	
	
}
