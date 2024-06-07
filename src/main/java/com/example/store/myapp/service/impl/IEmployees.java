package com.example.store.myapp.service.impl;
import java.util.List;
import com.example.store.myapp.model.Employees;

public interface IEmployees {
	List<Employees> getAllEmployees();
	Employees findById(long id);
	Employees save(Employees employees);
	void deleteById(long id);
}
