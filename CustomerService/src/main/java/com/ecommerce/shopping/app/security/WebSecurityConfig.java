//package com.ecommerce.shopping.app.security;
//
//
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig  {
//
////extends WebSecurityConfigurerAdapter
////	protected void configure(HttpSecurity http) throws Exception {
////		http.authorizeRequests()
////		.antMatchers("/oauth2/**","/").permitAll()
////		.antMatchers("/customer/**").authenticated()
////		.antMatchers("/**", "/error", "/webjars/**").permitAll().anyRequest().authenticated()		
////		.and()
////		.formLogin()
////				
////				.usernameParameter("email")
////				.permitAll()
////				
////
////		.and()
////	
////		.logout().permitAll();
////	
//
////	}
//
//	
//}
