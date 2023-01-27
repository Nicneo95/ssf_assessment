package com.example.PizzaApp.model;

import java.io.Serializable;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;

    // Set the attribute for the model class
    @NotNull(message = "Must at least select one type")
    private String pizza;

    @NotNull(message = "Must at least select one size")
    private String size;

    @Min(value = 1, message = "Quantity must at least be 1")
    @Max(value = 10, message = "Quantity cannot be more than 10")
    private int quantity;

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
