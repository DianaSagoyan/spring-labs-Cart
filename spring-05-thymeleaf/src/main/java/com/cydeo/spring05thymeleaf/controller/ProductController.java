package com.cydeo.spring05thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @GetMapping("/list")
    public String createProductPage(){
        return "/product/list";
    }

    @GetMapping("/create-form")
    public String formPage(Model model){
        return "/product/create-product";
    }

}
