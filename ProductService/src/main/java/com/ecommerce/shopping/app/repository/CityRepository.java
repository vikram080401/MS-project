package com.ecommerce.shopping.app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shopping.app.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}