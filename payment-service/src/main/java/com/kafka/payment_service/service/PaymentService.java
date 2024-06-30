package com.kafka.payment_service.service;

import com.kafka.payment_service.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
