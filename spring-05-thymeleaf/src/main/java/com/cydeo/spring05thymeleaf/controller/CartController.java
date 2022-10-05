package com.cydeo.spring05thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
    @GetMapping("/cart")
    public String cartPage(){
        return "/cart/show-cart";
    }
}
