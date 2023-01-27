package com.example.PizzaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.PizzaApp.model.Order;
import com.example.PizzaApp.model.Pizza;
import com.example.PizzaApp.service.PizzaService;

import jakarta.validation.Valid;

@Controller
public class FormController {

    @Autowired
    PizzaService pizzaService;

    @GetMapping(path = "/")
    public String showForm(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "index";
    }

    @PostMapping(path = "/pizza")
    public String postPizzaInput(@Valid Pizza pizza,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }
        pizzaService.savePizza(pizza, model);
        return "orderDetails";
    }

    @PostMapping(path = "/pizza/order")
    public String postPizzaInput(@Valid Order order,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "orderDetails";
        }
        pizzaService.saveOrder(order);
        model.addAttribute("order", order);
        return "orderConfirmation";
    }

}