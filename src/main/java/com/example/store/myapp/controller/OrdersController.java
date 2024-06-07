package com.example.store.myapp.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.store.myapp.business.OrdersBusiness;
import com.example.store.myapp.exception.BaseException;
import com.example.store.myapp.json.OrdersListJson;
import com.example.store.myapp.model.Orders;
import com.example.store.myapp.payload.OrdersPayload;
import com.example.store.myapp.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	OrdersBusiness ordersBusiness;
	
	public OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	@GetMapping(value = "/orders/get/all")
	public ResponseEntity<List<OrdersListJson>> getAllOrders() throws BaseException {
		return ResponseEntity.ok(ordersBusiness.getListOrders());
	}
	
	@GetMapping(value = "/orders/get/{id}")
	public ResponseEntity<OrdersListJson> getOrdersById(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(ordersBusiness.getOrdersById(id)); 
	}
	
	@GetMapping(value = "/orders/get/{id}/products")
	public ResponseEntity<List<OrdersListJson>> getOrdersByProductsId(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(ordersBusiness.getOrdersByProductsId(id));
	}
	
	@GetMapping(value = "/orders/get/{id}/employees")
	public ResponseEntity<List<OrdersListJson>> getOrdersByEmployeesId(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(ordersBusiness.getOrdersByEmployeesId(id));
	}
	
	@GetMapping(value = "/orders/get/{id}/customers")
	public ResponseEntity<List<OrdersListJson>> getOrdersByCustomersId(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(ordersBusiness.getOrdersByCustomersId(id));
	}
	
	@PostMapping(value = "/orders/save")
	public ResponseEntity<Void> saveOrder(@RequestBody OrdersPayload ordersPayload) throws BaseException {
		ordersBusiness.saveOrder(ordersPayload);
		return new ResponseEntity<>(HttpStatus.CREATED); 
	}
	
	@PutMapping(value = "/orders/update/{id}")
	public ResponseEntity<OrdersListJson> updateOrder(@PathVariable("id") long id, @RequestBody OrdersPayload ordersPayload) {
		Optional<Orders> orders = ordersService.findOptionalById(id);
		if(orders.isPresent()) {
			ordersBusiness.updateOrder(orders.get().getId(), ordersPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
