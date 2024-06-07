package com.example.store.myapp.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.store.myapp.model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
	Employees findById(long id);
	Optional<Employees> findOptionalById(long id);
}
