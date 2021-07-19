package com.ecommerce.shopping.oauth2.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.shopping.oauth2.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmail(String email);

}
