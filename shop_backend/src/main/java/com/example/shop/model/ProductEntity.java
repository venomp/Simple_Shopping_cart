package com.example.shop.model;
// Product entity mapped to the "products" table, can be extended to show relations between tables

public class ProductEntity {
    private Long id;
    private String name;
    private double price;
    private String imageUrl;
    private String descrition;

    
    public ProductEntity(Long id, String name, double price, String imageUrl,String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.descrition = description;
        
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription () {return descrition;}

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setDescription(String description) {this.descrition = description;
    }
}

