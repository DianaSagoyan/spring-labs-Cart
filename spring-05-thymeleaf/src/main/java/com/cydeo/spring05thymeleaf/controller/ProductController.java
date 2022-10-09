package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list" )
    public String listPage(Model model){

        List<Product> productList = productService.listProduct();
        model.addAttribute("productList", productList);

        return "/product/list";
    }

    @PostMapping ("/create-product")
    public String insertProduct(@ModelAttribute("product") Product product){
       productService.productCreate(product);
        return "redirect:/list";
    }
//    @GetMapping ("/create-product")
//    public String createProduct( ){
//
//        return "redirect:/list";
//    }

    @GetMapping("/create-form")
    public String formPage(Model model){
        model.addAttribute("product", new Product());
        return "/product/create-product";
    }

}
