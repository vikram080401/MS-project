package com.ecommerce.shopping.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.shopping.app.model.Users;

public interface UserRepository  extends CrudRepository<Users, Integer>{
	@Query("SELECT u FROM Users u WHERE u.customeremailid = ?1")
	public Users findBycustomeremailid(String customeremailid);
}
