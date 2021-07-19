package com.ecommerce.shopping.app.dao;




import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.shopping.app.model.Customers;

public interface CustomerRepository extends CrudRepository<Customers, Long> {

	public Customers findByCustomeremailid(String customeremailid);

	public Customers findByDateofbirth(String dateofbirth);

	public List<Customers> findByFirstname(String firstname);

}
