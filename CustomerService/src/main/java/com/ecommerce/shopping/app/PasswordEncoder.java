package com.ecommerce.shopping.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BCryptPasswordEncoder encoder=new  BCryptPasswordEncoder();
		System.out.println(encoder.encode("hello"));

	}

}
