package com.example.store.myapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.store.myapp.model.Products;
import com.example.store.myapp.repository.ProductsRepository;
import com.example.store.myapp.service.impl.IProducts;

@Service
public class ProductsService implements IProducts{
	
	ProductsRepository productsRepository; 
	
	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products findById(long id) {
		// TODO Auto-generated method stub
		return productsRepository.findById(id);
	}

	@Override
	public Products save(Products products) {
		// TODO Auto-generated method stub
		return productsRepository.save(products); 
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}
	public Optional<Products> findOptionalById(long id) {
		return productsRepository.findOptionalById(id);
	}

}
