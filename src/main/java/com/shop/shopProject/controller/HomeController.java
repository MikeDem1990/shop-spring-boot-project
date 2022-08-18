package com.shop.shopProject.controller;

import com.shop.shopProject.global.GlobalData;
import com.shop.shopProject.model.Category;
import com.shop.shopProject.model.User;
import com.shop.shopProject.repository.ProductRepository;
import com.shop.shopProject.service.CategoryService;
import com.shop.shopProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {


    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model)
    {

        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }


    @GetMapping("/shop")
    public String shop(Model model)
    {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProduct());
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "shop";
    }

    //обработка маршрута

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable Long id)
    {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products",productService.getAllProductByCategoryId(id));

        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewpProduct(Model model, @PathVariable Long id)
    {
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "viewProduct";
    }





}
