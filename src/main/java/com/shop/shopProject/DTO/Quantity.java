package com.shop.shopProject.DTO;

import lombok.Data;

@Data
public class Quantity {

    private Integer quantity;

    public Quantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Quantity() {
    }
}
