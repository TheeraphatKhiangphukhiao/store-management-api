package com.example.store.myapp.service.impl;
import java.util.List;
import com.example.store.myapp.model.Customers;

public interface ICustomers {
	List<Customers> getAllCustomers();
	Customers findById(long id);
	Customers save(Customers customers);
	void deleteById(long id);
}
