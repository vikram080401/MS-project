package com.ecommerce.shopping.app.service;

import java.util.List;

import com.ecommerce.shopping.app.model.Category;
import com.ecommerce.shopping.app.model.Product;



public interface IProductService {

	List<Product> findAll();
	Product findOne(long id);
	String DeleteOne(Product product);
	Product AddProduct(Product product);
	Category AddNewCategory(Category category);
	Product UpdateProductQuantity(Product product);
}
