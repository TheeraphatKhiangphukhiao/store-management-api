package com.example.store.myapp.business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.store.myapp.model.Customers;
import com.example.store.myapp.payload.CustomersPayload;
import com.example.store.myapp.service.CustomersService;

@Service
public class CustomersBusiness {
	@Autowired
	CustomersService customersService;
	
	public void saveCustomer(CustomersPayload customersPayload) {
		Customers customers = new Customers(
				customersPayload.getFirstName(),
				customersPayload.getLastName(),
				customersPayload.getC_user(),
				customersPayload.getPassword()
				);
		customersService.save(customers);
	}
	public void updateCustomer(long id, CustomersPayload customersPayload) {
		Customers customersData = customersService.findById(id);
		customersData.setFirstName(customersPayload.getFirstName());
		customersData.setLastName(customersPayload.getLastName());
		customersData.setC_user(customersPayload.getC_user());
		customersData.setPassword(customersPayload.getPassword());
		
		customersService.save(customersData);
	}
}
