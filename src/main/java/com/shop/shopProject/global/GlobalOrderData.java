package com.shop.shopProject.global;

import com.shop.shopProject.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalOrderData {
//    public static List<Product> order;
//
//
//    static {
//        order = new ArrayList<>();
//    }


    public static Map<Product,Integer> order;
    public static int quantity;


    static {
        order = new HashMap<>();
    }
}
