package com.example.store.myapp.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.store.myapp.business.ProductsBusiness;
import com.example.store.myapp.exception.BaseException;
import com.example.store.myapp.json.ProductsListJson;
import com.example.store.myapp.model.Products;
import com.example.store.myapp.payload.ProductsPayload;
import com.example.store.myapp.service.ProductsService;

@RestController
@RequestMapping("/api")
public class ProductsController {
	
	@Autowired
	ProductsService productsService;
	
	@Autowired
	ProductsBusiness productsBusiness;
	
	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	@PostMapping(value = "/products/save")
	public ResponseEntity<Void> saveProduct(@RequestBody ProductsPayload productsPayload) throws BaseException {
		productsBusiness.saveProduct(productsPayload);
		return new ResponseEntity<>(HttpStatus.CREATED); 
	}
	@PutMapping(value = "/products/update/{id}")
	public ResponseEntity<ProductsListJson> updateProduct(@PathVariable("id") long id, @RequestBody ProductsPayload productsPayload) {
		Optional<Products> productsData = productsService.findOptionalById(id);
		if(productsData.isPresent()) {
			productsBusiness.updateProduct(productsData.get().getId(), productsPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
