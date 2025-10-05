package com.example.shop.dto;

/**
 * Data Transfer Object representing a Product item.
 * Contains details such as item ID, price, name, description, image URL, and quantity.
 */

public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private String imageUrl;
    private String description;

    public ProductDTO(Long id, String name, double price, String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription (){return description;}

    // Setters (optional)
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setDescription(String description) { this.description = description; }
}

