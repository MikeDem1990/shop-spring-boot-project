package com.shop.shopProject.controller;

import com.shop.shopProject.DTO.Quantity;
import com.shop.shopProject.global.GlobalData;
import com.shop.shopProject.model.Product;
import com.shop.shopProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    @Autowired
    ProductService productService;


//    @GetMapping("/addToCart/{id}")
//
//    public String addToCart(@PathVariable long id , @RequestParam(value = "quantity") Integer quantity){
////        GlobalData.cart.add(productService.getProductById(id).get());
//        GlobalData.cart.put(productService.getProductById(id).get(), quantity);
//
//        return "redirect:/shop";
//    }


    @GetMapping("/addToCart/{id}")

    public String addToCart(@PathVariable long id ){
        GlobalData.cart.add(productService.getProductById(id).get());
//        GlobalData.cart.put(productService.getProductById(id).get());

        return "redirect:/shop";
    }

//    @PostMapping("/addToCart/{id}")
//
//    public String addToCart(@PathVariable long id ,@PathVariable Integer quantity ){
////        GlobalData.cart.add(productService.getProductById(id).get());
//        GlobalData.cart.put( productService.getProductById(id).get(), quantity);
//
//        return "redirect:/shop";
//    }

    @GetMapping("/cart")
    public String cartGet (Model model)
    {

        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
//        model.addAttribute("GG",GlobalData.cart);
        return "cart";


    }




    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index)
    {
        GlobalData.cart.remove(index);
        return "redirect:/cart";

    }




    @GetMapping("/checkout")
    public String checkout (Model model)
    {

        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());

        return "checkout";
    }

//    @PostMapping("/cart")
//    public String Recalculation(@RequestParam(value = "quantity") Integer quantity, Model model)
//    {
//        GlobalData.quantity = quantity;
//
//        System.out.println(GlobalData.quantity);
//
//
//        return "redirect:/cart";
//    }

////сумма
//    private double sum(HttpSession session) {
//        List<Item> cart = (List<Item>) session.getAttribute("cart");
//        double s = 0;
//
//        for (Item item: cart){
//            s += item.getQuantity()
//                    * item.getProduct().getPrice().doubleValue();
//        }
//        return s;
//    }

}
