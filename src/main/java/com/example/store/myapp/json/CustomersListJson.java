package com.example.store.myapp.json;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.store.myapp.model.Customers;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomersListJson {
	private long id;
	private String firstName;
	private String lastName;
	private String c_user;
	private String password;
	private LocalDateTime created_at;
	
	public static CustomersListJson packJson(Customers customers) {
		CustomersListJson clj = new CustomersListJson();
		clj.setId(customers.getId());
		clj.setFirstName(customers.getFirstName());
		clj.setLastName(customers.getLastName());
		clj.setC_user(customers.getC_user());
		clj.setPassword(customers.getPassword());
		clj.setCreated_at(customers.getCreated_at());
		
		return clj;
	}
	public static List<CustomersListJson> packJsons(List<Customers> customers) {
		List<CustomersListJson> clj = new ArrayList<CustomersListJson>();
		for (Customers customer : customers) {
			clj.add(packJson(customer));
		}
		return clj;
	}
}
