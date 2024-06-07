package com.example.store.myapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.store.myapp.model.Orders;
import com.example.store.myapp.repository.OrdersRepository;
import com.example.store.myapp.service.impl.IOrders;

@Service
public class OrdersService implements IOrders {
	
	OrdersRepository ordersRepository;
	
	public OrdersService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}
	
	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return ordersRepository.findAll();
	}

	@Override
	public Orders findById(long id) {
		// TODO Auto-generated method stub
		return ordersRepository.findById(id);
	}

	@Override
	public Orders save(Orders orders) {
		// TODO Auto-generated method stub
		return ordersRepository.save(orders);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}
	public Optional<Orders> findOptionalById(long id) {
		return ordersRepository.findOptionalById(id);
	}

	@Override
	public List<Orders> findByCustomersId(long id) {
		// TODO Auto-generated method stub
		return ordersRepository.findByCustomersId(id);
	}

	@Override
	public List<Orders> findByEmployeesId(long id) {
		// TODO Auto-generated method stub
		return ordersRepository.findByEmployeesId(id);
	}

	@Override
	public List<Orders> findByProductsId(long id) {
		// TODO Auto-generated method stub
		return ordersRepository.findByProductsId(id);
	}

}
