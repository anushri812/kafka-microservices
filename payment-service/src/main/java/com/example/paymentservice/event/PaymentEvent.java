package com.example.paymentservice.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PaymentEvent {
    private Boolean status;
    private String message;
}
