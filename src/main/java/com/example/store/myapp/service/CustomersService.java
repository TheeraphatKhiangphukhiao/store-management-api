package com.example.store.myapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.store.myapp.model.Customers;
import com.example.store.myapp.repository.CustomersRepository;
import com.example.store.myapp.service.impl.ICustomers;

@Service
public class CustomersService implements ICustomers {
	
	CustomersRepository customersRepository;
	
	public CustomersService(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}
	
	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customers findById(long id) {
		// TODO Auto-generated method stub
		return customersRepository.findById(id);
	}

	@Override
	public Customers save(Customers customers) {
		// TODO Auto-generated method stub
		return customersRepository.save(customers);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}
	public Optional<Customers> findOptionalById(long id) {
		return customersRepository.findOptionalById(id);
	}

}
