package com.example.store.myapp.service.impl;
import java.util.List;
import com.example.store.myapp.model.Orders;

public interface IOrders {
	List<Orders> getAllOrders();
	Orders findById(long id);
	Orders save(Orders orders);
	
	List<Orders> findByCustomersId(long id);
	List<Orders> findByEmployeesId(long id);
	List<Orders> findByProductsId(long id);
	
	void deleteById(long id);
}
