package com.example.store.myapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.store.myapp.model.Employees;
import com.example.store.myapp.repository.EmployeesRepository;
import com.example.store.myapp.service.impl.IEmployees;

@Service
public class EmployeesService implements IEmployees {
	
	EmployeesRepository employeesRepository;
    
	public EmployeesService(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}
	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees findById(long id) {
		// TODO Auto-generated method stub
		return employeesRepository.findById(id);
	}

	@Override
	public Employees save(Employees employees) {
		// TODO Auto-generated method stub
		return employeesRepository.save(employees);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}
	public Optional<Employees> findOptionalById(long id) {
		return employeesRepository.findOptionalById(id);
	}
}
