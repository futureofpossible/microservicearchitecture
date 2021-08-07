package com.springcloud.payment.service;

import com.springcloud.common.entity.Payment;

import java.util.List;

public interface PayService {
    int savePayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getPayments();
    String pay();
    String payTimeout();
    String payCircuitBreaker();
}
