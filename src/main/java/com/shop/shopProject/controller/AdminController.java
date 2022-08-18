package com.shop.shopProject.controller;


import com.shop.shopProject.DTO.productDTO;
import com.shop.shopProject.model.Category;
import com.shop.shopProject.model.Product;
import com.shop.shopProject.service.CategoryService;
import com.shop.shopProject.service.OrderService;
import com.shop.shopProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController  {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

//    File path = new  File(ResourceUtils.getURL("classpath:static/productImages").getPath()).getAbsoluteFile();
//    String   uploadDir = path.getAbsolutePath();

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @GetMapping("/admin")
    public String adminHome(){

        return "adminHome";
    }

    @GetMapping("admin/categories")
    public String getCategory(Model model)
    {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("admin/categories/add")
    public String getCategoryAdd(Model model)
    {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("admin/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") Category category)
    {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("admin/categories/update/{id}")
    public String updateCatregory(@PathVariable Long id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()){
            model.addAttribute("category" , category.get());
            return "categoriesAdd";
        } else
        {
            return "404 not found!";
        }
    }

    //product

    @GetMapping("/admin/products")
    public String getProducts(Model model){
        model.addAttribute("products" , productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String getProductAdd(Model model){

        model.addAttribute("productDTO", new productDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO") productDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName) throws IOException{
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());

        String imageUUID;

        if (!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNamePath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNamePath, file.getBytes());
        } else {
            imageUUID = imgName;
        }

        product.setImageName(imageUUID);
        productService.addProduct(product);


        return "redirect:/admin/products";
    }



    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){

        productService.removeProductById(id);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model)
    {
        Product product = productService.getProductById(id).get();
        productDTO productDTO = new productDTO();
        productDTO.setId(id);
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setWeight(product.getWeight());
        productDTO.setImageName(product.getImageName());


        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productDTO", productDTO);

        return "productsAdd";
    }



    //orders

    @GetMapping("admin/orders")
    public String ordersDetail(Model model){

        model.addAttribute("orders", orderService.getAllOrders());


        return "orderDetails";
    }




}



