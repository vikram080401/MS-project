package com.ecommerce.shopping.oauth2.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;


@EnableAutoConfiguration
@EnableWebSecurity
public class ClientOAuth2Config extends WebSecurityConfigurerAdapter   {

	 protected void configure(HttpSecurity http) throws Exception {
	    	// @formatter:off
	        http
	            .authorizeRequests(a -> a
	                .antMatchers("/", "/error", "/webjars/**").permitAll()
	                .anyRequest().authenticated()
	            )
	            .exceptionHandling(e -> e
	                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
	            )
	            .oauth2Login()
	            .and()
	            .logout().logoutSuccessUrl("/").permitAll();
	        // @formatter:on
	    }
}
