package com.example.PizzaApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.example.PizzaApp.model.Order;
import com.example.PizzaApp.model.Pizza;

@Component("PizzaService")
public class PizzaService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public int saveOrder(final Order order) {
        System.out.println("order " + order.toJSON().toString());
        redisTemplate.opsForValue().set(order.getOrderId(), order.toJSON().toString());
        String result = (String) redisTemplate.opsForValue().get(order.getOrderId());
        if (result != null)
            return 1;
        return 0;
    }

    public void savePizza(Pizza pizza, Model model) {

        System.out.println(pizza.getPizza());
        System.out.println(pizza.getSize());
        System.out.println(pizza.getQuantity());

        model.addAttribute("pizza", new Pizza());
    }

}
