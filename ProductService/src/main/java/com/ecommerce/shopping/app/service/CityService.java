package com.ecommerce.shopping.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping.app.model.City;
import com.ecommerce.shopping.app.repository.CityRepository;


@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        return (List<City>) repository.findAll();
    }
}