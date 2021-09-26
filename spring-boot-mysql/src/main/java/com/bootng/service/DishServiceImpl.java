package com.bootng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import example.restapi.model.Dish;
import example.restapi.repository.DishRepository;
//import org.springframework.data.jpa.*;
@Service
public abstract class DishServiceImpl  implements DishService{
	
	@Autowired
	DishRepository repo;
	
    public List<Dish> getDish() {
    	
    	List<Dish> n = new ArrayList<>();
    	//return n;
    		return repo.findAll();
    }

	@Override
	public Dish createDish(Dish request) {
		return repo.save(request);
	}
}
