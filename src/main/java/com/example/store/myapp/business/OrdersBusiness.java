package com.example.store.myapp.business;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.store.myapp.json.OrdersListJson;
import com.example.store.myapp.model.Orders;
import com.example.store.myapp.payload.OrdersPayload;
import com.example.store.myapp.service.OrdersService;

@Service
public class OrdersBusiness {
	@Autowired
	OrdersService ordersService;
	
	public List<OrdersListJson> getListOrders() {
		return OrdersListJson.packJsons(ordersService.getAllOrders());
	}
	
	public List<OrdersListJson> getOrdersByProductsId(long id) {
		return OrdersListJson.packJsons(ordersService.findByProductsId(id)); 
	}
	
	public List<OrdersListJson> getOrdersByEmployeesId(long id) {
		return OrdersListJson.packJsons(ordersService.findByEmployeesId(id));
	}
	
	public OrdersListJson getOrdersById(long id) {
		return OrdersListJson.packJson(ordersService.findById(id));
	}
	
	public List<OrdersListJson> getOrdersByCustomersId(long id) {
		return OrdersListJson.packJsons(ordersService.findByCustomersId(id));
	}
	
	public void saveOrder(OrdersPayload ordersPayload) {
		Orders orders = new Orders(
				ordersPayload.getCustomer_id(),
				ordersPayload.getEmployee_id(),
				ordersPayload.getProduct_id(),
				ordersPayload.getOrder_total()
				);
		ordersService.save(orders);
	}
	public void updateOrder(long id, OrdersPayload ordersPayload) {
		Orders orders = ordersService.findById(id);
		orders.setCustomers(ordersPayload.getCustomer_id());
		orders.setEmployees(ordersPayload.getEmployee_id());
		orders.setProducts(ordersPayload.getProduct_id());
		orders.setOrder_total(ordersPayload.getOrder_total());
		
		ordersService.save(orders);
	}
}
