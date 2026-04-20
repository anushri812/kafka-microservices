package com.example.notificationservice.service;

import com.example.notificationservice.event.PaymentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationEventConsumer {

    @KafkaListener(topics = "payments-topic")
    public void processPaymentEvent(PaymentEvent paymentEvent) {
        System.out.println("Received event: " + paymentEvent);

        if (paymentEvent.getStatus()) {
            System.out.println("Notification: " + paymentEvent.getMessage());
        }
    }
}
