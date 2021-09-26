package com.bootng.service;

import java.util.List;

import org.springframework.stereotype.Component;

import example.restapi.model.Dish;

@Component
public interface DishService {
	//Dish getDish(Long id);
    List<Dish> getDish();
	Dish createDish(Dish request);
	
	Dish findAll(Dish request);
	
}
