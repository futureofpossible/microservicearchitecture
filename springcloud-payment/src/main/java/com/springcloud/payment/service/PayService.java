package com.springcloud.payment.service;

import com.springcloud.common.entity.Payment;

public interface PayService {
    int savePayment(Payment payment);
    Payment getPaymentById(Long id);
}
