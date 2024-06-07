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
import com.example.store.myapp.business.CustomersBusiness;
import com.example.store.myapp.exception.BaseException;
import com.example.store.myapp.json.CustomersListJson;
import com.example.store.myapp.model.Customers;
import com.example.store.myapp.payload.CustomersPayload;
import com.example.store.myapp.service.CustomersService;

@RestController
@RequestMapping("/api")
public class CustomersController {
	
	@Autowired
	CustomersService customersService;
	
	@Autowired
	CustomersBusiness customersBusiness;
	
	public CustomersController(CustomersService customersService) {
		this.customersService = customersService;
	}
	
	@PostMapping(value = "/customers/save")
	public ResponseEntity<Void> saveCustomers(@RequestBody CustomersPayload customersPayload) throws BaseException {
		customersBusiness.saveCustomer(customersPayload);
		return new ResponseEntity<>(HttpStatus.CREATED); 
	}
	@PutMapping(value = "/customers/update/{id}")
	public ResponseEntity<CustomersListJson> updateCustomer(@PathVariable("id") long id, @RequestBody CustomersPayload customersPayload) {
		Optional<Customers> customerData = customersService.findOptionalById(id);
		if(customerData.isPresent()) {
			customersBusiness.updateCustomer(customerData.get().getId(), customersPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
