package com.example.orderservice.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEvent {
    private String orderId;
    private double amount;
}