package com.shop.shopProject.DTO;

import com.shop.shopProject.model.Category;
import lombok.Data;

@Data
public class productDTO {

    private Long id;
    private String name;
    private Long categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;
}
