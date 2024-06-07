package com.example.store.myapp.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.store.myapp.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
	Orders findById(long id);
	List<Orders> findByCustomersId(long id);
	List<Orders> findByEmployeesId(long id);
	List<Orders> findByProductsId(long id);
	Optional<Orders> findOptionalById(long id);
}
