package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Produit;

public interface ICrudService<T, ID> {

	List<T> getAll();
	
	
	void add(T object);
	void update(T object);
	void delete(ID id);
		
	
}
