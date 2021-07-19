package com.goods.spring.mvc.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.goods.spring.mvc.app.model.Users;



public interface UserRepository  extends CrudRepository<Users, Integer>{
	@Query("SELECT u FROM Users u WHERE u.customeremailid = ?1")
	public Users findBycustomeremailid(String customeremailid);
}
