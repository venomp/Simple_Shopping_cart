package com.example.shop.dto;

/**
 * Data Transfer Object representing a shopping cart item.
 * Contains details such as item ID, price, name, description, image URL, and quantity.
 */
public class CartDTO {
    private int id;
    private int quantity;

    public CartDTO(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    @Override
public String toString() {
    return "CartDTO{" +
            "id=" + id +
            ", quantity=" + quantity +
            '}';
}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
