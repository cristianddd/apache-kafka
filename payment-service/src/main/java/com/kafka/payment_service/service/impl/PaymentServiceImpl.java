package com.kafka.payment_service.service.impl;

import com.kafka.payment_service.model.Payment;
import com.kafka.payment_service.service.PaymentService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    @SneakyThrows
    public void sendPayment(Payment payment) {
      log.info("Recebi o pagamento {}", payment);
      Thread.sleep(1000);
      log.info("enviando pagamento...");
      kafkaTemplate.send("payment-topic", payment);
    }
}
