package com.ecommerce.shopping.app.repository;





import org.springframework.data.jpa.repository.JpaRepository;


import com.ecommerce.shopping.app.model.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{

	
	public Category findByDescription(String description);
}
