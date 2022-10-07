package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String cartPage(Model model){

        return "/cart/show-cart";
    }

    @GetMapping("/addToCart/{id}/{quantity}")
    public String addingToCart(@PathVariable("id")UUID id, @PathVariable("quantity") Integer quantity, @ModelAttribute("product") Product product, Model model){

        model.addAttribute("product", product);
        cartService.addToCart(id, quantity);

        return "/cart/show-cart";
    }
}
