package com.shop.shopProject.global;

import com.shop.shopProject.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalData {
    public static List<Product> cart;
    public static int quantity;


    static {
        cart = new ArrayList<>();
    }



}
