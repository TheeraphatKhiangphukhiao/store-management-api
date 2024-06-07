package com.example.store.myapp.service.impl;
import java.util.List;
import com.example.store.myapp.model.Products;

public interface IProducts {
	List<Products> getAllProducts();
	Products findById(long id);
	Products save(Products products);
	void deleteById(long id);
}
