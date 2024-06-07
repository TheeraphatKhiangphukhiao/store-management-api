package com.example.store.myapp.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Products")
@Table(
		name = "products"
)

public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "product_name", nullable = false)
	private String product_name;
	
	@Column(name = "price", nullable = false)
	private Integer price;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	
	// Constructor ของ class ที่ไม่กำหนด parameters (เผื่อได้ใช้)
	public Products() {
		;
	}

	public Products(String product_name, Integer price) {
		super();
		this.product_name = product_name;
		this.price = price;
	}
	
}
