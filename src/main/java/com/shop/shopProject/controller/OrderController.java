package com.shop.shopProject.controller;

import com.shop.shopProject.DTO.orderDTO;
import com.shop.shopProject.DTO.productDTO;
import com.shop.shopProject.global.GlobalData;
import com.shop.shopProject.model.Order;
import com.shop.shopProject.model.Product;
import com.shop.shopProject.model.User;
import com.shop.shopProject.repository.OrderRepository;

import com.shop.shopProject.service.CustomUserDetailService;
import com.shop.shopProject.service.OrderService;
import com.shop.shopProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

@Controller
public class OrderController {


    @Autowired
    OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;



//    @GetMapping("/checkout")
//    public String getOrder(@PathVariable Integer id, Model model){
//
//
//
//    }
//
//    @GetMapping("/checkout")
//    public String getOrderAdd(Model model){
//
//        model.addAttribute("orderDTO", new orderDTO());
//
//        return "productsAdd";
//    }

//    @GetMapping("/checkout")
//    public String orderAdd (Model model) {return "checkout"; }

    @PostMapping("/checkout")
    public String orderPostAdd(@RequestParam String firstname, @RequestParam String lastname , @RequestParam String city , @RequestParam String region,
                               @RequestParam String address, @RequestParam String telephone, @RequestParam String  email, @RequestParam String information, Model model)
    {


        Date date = new Date();

//        User auth = (User) request.getSession().getAttribute("auth");
//        System.out.println(username);
//        User user = (User) customUserDetailService.loadUserByUsername(authentication.getName());

//        for (Map.Entry<Product,Integer> entry : GlobalData.cart.entrySet())
//        {
//            Order order = new Order(firstname,lastname,city,region,address,telephone,email,information, date, entry.getValue());
////            order.setUser((Long) httpSession.getAttribute("id"));
////            order.setUser(username);
//            order.setProduct(entry.getKey());
//            orderRepository.save(order);
//        }



        for (Product pr : GlobalData.cart)
        {
            Order order = new Order(firstname,lastname,city,region,address,telephone,email,information, date,GlobalData.quantity);

            order.setProduct(pr);
            orderRepository.save(order);


        }

        return "index";
    }

//    @PostMapping("/checkout")
//    public String productAddPost(@ModelAttribute("orderDTO") orderDTO orderDTO) throws IOException {
//        Order order = new Order();
//        order.setId(orderDTO.getId());
//        order.setFirstname(orderDTO.getFirstname());
//        order.setLastname(orderDTO.getLastname());
//        order.setCity(orderDTO.getCity());
//        order.setRegion(orderDTO.getRegion());
//        order.setAddress(orderDTO.getAddress());
//        order.setTelephone(orderDTO.getTelephone());
//        order.setEmail(orderDTO.getEmail());
//        order.setInformation(orderDTO.getInformation());
//
//
//        orderService.addProduct(order);
//
//
//        return "redirect:/index";
//    }


}
