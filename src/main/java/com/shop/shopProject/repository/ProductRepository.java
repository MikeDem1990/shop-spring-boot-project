package com.shop.shopProject.repository;

import com.shop.shopProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //int
    List<Product> findAllByCategoryId(Long id);
}
