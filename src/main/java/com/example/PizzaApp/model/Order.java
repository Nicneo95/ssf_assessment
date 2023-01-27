package com.example.PizzaApp.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.example.PizzaApp.model.Pizza;


public class Order implements Serializable {

    @Autowired
    Pizza pizza;

    private static final long serialVersionUID = 1L;

    private String orderId;

    @NotNull(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @NotNull(message = "Address cannot be empty")
    private String address;

    @NotNull(message = "Phone number cannot be empty")
    @Size(min = 8, message = "Phone number must be at least 8 digit.")
    private String phone;

    private Boolean rush;
    private String comments;
    private int total;

    public Order() {
        this.orderId = generateId(8);
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getRush() {
        return rush;
    }
    public void setRush(Boolean rush) {
        this.rush = rush;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    // Create a method to generate id
    private synchronized String generateId(int numChars) {
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < numChars) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0, numChars);
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("orderId", this.getOrderId())
                .add("name", this.getName())
                .add("address", this.getAddress())
                .add("phone", this.getPhone())
                .add("rush", this.getRush())
                .add("comments", this.getComments())
                .add("pizza", pizza.getPizza())
                .add("size", pizza.getSize())
                .add("quantity", pizza.getQuantity())
                .add("total", this.getTotal())
                .build();
    }
}
