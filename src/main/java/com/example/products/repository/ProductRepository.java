package com.example.products.repository;



import com.example.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);

    Product findByCategory(Long id);
    List<Product> findProductsByCategory_Id(Long id);
}
