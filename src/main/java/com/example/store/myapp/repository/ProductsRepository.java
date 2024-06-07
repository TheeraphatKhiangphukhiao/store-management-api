package com.example.store.myapp.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.store.myapp.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	Products findById(long id);
	Optional<Products> findOptionalById(long id);
}
