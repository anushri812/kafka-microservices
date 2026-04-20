package com.example.paymentservice.service;

import com.example.paymentservice.event.OrderEvent;
import com.example.paymentservice.event.PaymentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventConsumer {
    private PaymentEvent paymentEvent;

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    public PaymentEventConsumer(KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "orders-topic")
    public void processOrderEvent(OrderEvent event) {

        paymentEvent = new PaymentEvent(false, "processing payment");

        System.out.println(paymentEvent.getMessage() + event.getOrderId() + "payment status: " + paymentEvent.getStatus());

        String message = "Payment done for " + event.getOrderId();
        paymentEvent.setMessage(message);
        paymentEvent.setStatus(true);

        kafkaTemplate.send("payments-topic", paymentEvent);
    }
}
