package com.example.paymentservice.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEvent {
    private String orderId;
    private double amount;
}
