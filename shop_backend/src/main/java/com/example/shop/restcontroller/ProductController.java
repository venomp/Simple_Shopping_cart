package com.example.shop.restcontroller;

// Rest API endpoints


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.shop.dto.CartDTO;
import com.example.shop.dto.ProductDTO;
import com.example.shop.service.CartService;
import com.example.shop.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    // get all products
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    
    // Post method to add cart data 
    @PostMapping("/checkout")
    public ResponseEntity<List<CartDTO>>  saveCartData(@RequestBody List<CartDTO> item){
        CartService cartService = new CartService();

         List<CartDTO> cart = cartService.addToCart(item);
        return ResponseEntity.ok(cart);
    }
    
    
}
