package com.ecommerce.shopping.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.shopping.app.model.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

}
