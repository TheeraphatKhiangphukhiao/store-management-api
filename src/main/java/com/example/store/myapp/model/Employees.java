package com.example.store.myapp.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Employees")
@Table(
		name = "employees",
		uniqueConstraints = {
				@UniqueConstraint(name = "employees_user_unique", columnNames = "user")
		}
)

public class Employees {
	
	// Attribute ของ class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	// ข้อมูลชนิด Long คือ primary key
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "user", unique = true, nullable = false)
	private String user;
	
	@Column(name = "password", nullable = false) 
	private String password;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;
	
	// Constructor ของ class ที่ไม่กำหนด parameters (เผื่อได้ใช้)
	public Employees() {
		;
	}

	public Employees(String firstName, String lastName, String user, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.password = password;
	}
	
}
