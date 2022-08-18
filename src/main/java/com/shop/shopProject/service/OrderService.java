package com.shop.shopProject.service;


import com.shop.shopProject.model.Order;
import com.shop.shopProject.model.Product;
import com.shop.shopProject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(){return orderRepository.findAll();}

    public void addOrders(Order order){
        orderRepository.save(order);
    }

    //long
    public void removeOrdersById(Integer id){
        orderRepository.deleteById(id);
    }

    public Optional<Order> getOrdersById(Integer id){
        return orderRepository.findById(id);
    }



}
