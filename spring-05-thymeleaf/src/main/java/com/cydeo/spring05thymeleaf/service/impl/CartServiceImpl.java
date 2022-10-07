package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;
    List<CartItem> cartItemList = new ArrayList<>();

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method
        //todo initialise cart item
        //todo calculate cart total amount
        //todo add to cart

        productService.findProductById(productId);
        CartItem cartItem = new CartItem();
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        
        BigDecimal deletingPrice = CART.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().toString().equals(productId.toString())).findAny().orElseThrow().getProduct().getPrice();

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(deletingPrice));

        CART.getCartItemList().removeIf(cartItem -> cartItem.getProduct().getId().toString().equals(productId.toString()));

        return true;
    }
}
