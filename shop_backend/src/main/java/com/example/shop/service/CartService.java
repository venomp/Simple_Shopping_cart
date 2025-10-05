package com.example.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shop.dto.CartDTO;
@Service
public class CartService {
    private final List<CartDTO> cartdata = new ArrayList<>();

    public List<CartDTO> addToCart(List<CartDTO> data) {
        cartdata.addAll(data);
        System.out.println(cartdata);
        return cartdata;
    }
}