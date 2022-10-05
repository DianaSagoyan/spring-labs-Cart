package com.cydeo.spring05thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private BigDecimal cartTotalAmount;
    private List<CartItem> cartItemList;

}
