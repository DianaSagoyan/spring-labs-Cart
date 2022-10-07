package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CartController {

    private final CartServiceImpl cartServiceImpl;

    public CartController(CartServiceImpl cartServiceImpl) {
        this.cartServiceImpl = cartServiceImpl;
    }

    @GetMapping("/cart")
    public String cartPage(Model model){

        model.addAttribute("cartItemList", cartServiceImpl.CART.getCartItemList());
        model.addAttribute("cart", cartServiceImpl.CART);

        return "/cart/show-cart";
    }

    @GetMapping("/addToCart")
    public String addingToCart(@PathVariable("id")UUID id, @PathVariable("quantity") Integer quantity){

        cartServiceImpl.addToCart(id, quantity);

        return "/cart/show-cart";
    }
}
