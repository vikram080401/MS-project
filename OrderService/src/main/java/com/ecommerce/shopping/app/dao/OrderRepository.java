package com.ecommerce.shopping.app.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.shopping.app.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	
	public List<Order> findByCustomerid(Long id);
	public List<Order> findByOrdernumber(Long id);
		
	 
}
