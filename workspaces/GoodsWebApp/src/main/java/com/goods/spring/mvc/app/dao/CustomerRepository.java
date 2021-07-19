package com.goods.spring.mvc.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.goods.spring.mvc.app.model.Customers;



public interface CustomerRepository extends CrudRepository<Customers, Long> {

	public Customers findByCustomeremailid(String customeremailid);


}
