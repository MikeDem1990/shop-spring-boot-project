package com.shop.shopProject.service;

import com.shop.shopProject.model.Product;
import com.shop.shopProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct(){return productRepository.findAll();}

    public void addProduct(Product product){
        productRepository.save(product);
    }

    //long
    public void removeProductById(Long id){
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProductByCategoryId(Long id)
    {
        return productRepository.findAllByCategoryId(id);
    }

}
