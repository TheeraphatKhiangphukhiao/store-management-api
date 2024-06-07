package com.example.store.myapp.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductsPayload {
	
	private String product_name;
	private int price;
}
