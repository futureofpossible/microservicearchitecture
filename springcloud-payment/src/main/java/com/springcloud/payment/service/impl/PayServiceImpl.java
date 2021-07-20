package com.springcloud.payment.service.impl;

import com.springcloud.common.entity.Payment;
import com.springcloud.payment.dao.PaymentDao;
import com.springcloud.payment.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PayServiceImpl implements PayService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int savePayment(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
