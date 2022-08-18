package com.shop.shopProject.repository;

import com.shop.shopProject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
