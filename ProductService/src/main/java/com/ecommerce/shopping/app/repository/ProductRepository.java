package com.ecommerce.shopping.app.repository;

import org.springframework.data.repository.CrudRepository;


import com.ecommerce.shopping.app.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	public Product findByDescription(String description);
}
