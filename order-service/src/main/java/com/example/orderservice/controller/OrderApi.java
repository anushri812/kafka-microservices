package com.example.orderservice.controller;

import com.example.orderservice.event.OrderEvent;
import com.example.orderservice.producer.OrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderApi {

    final OrderProducer producer;
    @PostMapping
    public String createOrder(@RequestBody OrderEvent event) {
        producer.send(event);
        return "Order sent";
    }

    @GetMapping("/test")
    public String test() {
        return "working";
    }
}
