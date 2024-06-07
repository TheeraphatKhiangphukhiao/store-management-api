package com.example.store.myapp.json;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.store.myapp.model.Customers;
import com.example.store.myapp.model.Employees;
import com.example.store.myapp.model.Orders;
import com.example.store.myapp.model.Products;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrdersListJson {
	private long id;
	private Customers customer;
	private Employees employee;
	private Products product;
	private int order_total;
	private LocalDateTime createdAt;
	
	public static OrdersListJson packJson(Orders orders) {
		OrdersListJson olj = new OrdersListJson();
		olj.setId(orders.getId());
		olj.setCustomer(orders.getCustomers());
		olj.setEmployee(orders.getEmployees());
		olj.setProduct(orders.getProducts());
		olj.setOrder_total(orders.getOrder_total());
		olj.setCreatedAt(orders.getCreated_at());
		
		return olj;
	}
	public static List<OrdersListJson> packJsons(List<Orders> orders) {
		List<OrdersListJson> olj = new ArrayList<OrdersListJson>();
		for (Orders order : orders) {
			olj.add(packJson(order));
		}
		return olj;
	}
}
