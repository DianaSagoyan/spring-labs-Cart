package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @GetMapping("/list" )
    public String listPage(){
        return "/product/list";
    }

    @PostMapping ("/create-product")
    public String createProductPage(){
        return "/product/list";
    }

    @GetMapping("/create-form")
    public String formPage(Model model){

        model.addAttribute("product", new Product());
        return "/product/create-product";
    }

}
