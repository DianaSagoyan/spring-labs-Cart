package com.cydeo.spring05thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {
    @GetMapping("/cart")
    public String cartPage(){
        return "/cart/show-cart";
    }

    @GetMapping("/addToCart/{id}/{quantity}")
    public String addingToCart(@PathVariable("id")UUID id, @PathVariable("quantity") Integer qantity){
        return "/cart/showCart";
    }
}
