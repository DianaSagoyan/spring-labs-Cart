package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

import static com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl.CART;

@Controller
public class CartController {

    private final CartServiceImpl cartServiceImpl;

    public CartController(CartServiceImpl cartServiceImpl) {
        this.cartServiceImpl = cartServiceImpl;
    }

    @GetMapping("/cart")
    public String cartPage(Model model){
        model.addAttribute("cart", CART);
        return "/cart/show-cart";
    }

    @GetMapping("/addToCart/{id}/{quantity}")
    public String addingToCart(@PathVariable("id")UUID id,
                               @PathVariable("quantity") Integer quantity){

        cartServiceImpl.addToCart(id, quantity);

        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable("id") UUID id){

        cartServiceImpl.deleteFromCart(id);

        return "redirect:/cart";
    }
}
