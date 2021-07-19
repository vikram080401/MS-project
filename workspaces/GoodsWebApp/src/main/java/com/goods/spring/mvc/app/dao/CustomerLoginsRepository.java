package com.goods.spring.mvc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goods.spring.mvc.app.model.CustomerLogins;




public interface CustomerLoginsRepository extends JpaRepository<CustomerLogins, Long> {

	public CustomerLogins findByCustomerusername(String customerusername);

	
}
