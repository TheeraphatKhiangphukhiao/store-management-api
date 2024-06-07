package com.example.store.myapp.payload;
import com.example.store.myapp.model.Customers;
import com.example.store.myapp.model.Employees;
import com.example.store.myapp.model.Products;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrdersPayload {
	private Customers customer_id;
	private Employees employee_id;
	private Products product_id;
	private int order_total;
}
