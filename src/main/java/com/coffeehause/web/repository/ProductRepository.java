package com.coffeehause.web.repository;

import com.coffeehause.web.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}