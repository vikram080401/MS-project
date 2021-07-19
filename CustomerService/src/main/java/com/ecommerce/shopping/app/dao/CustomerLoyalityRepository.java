package com.ecommerce.shopping.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shopping.app.model.CustomerLoyality;

public interface CustomerLoyalityRepository extends JpaRepository<CustomerLoyality, Long> {

}
