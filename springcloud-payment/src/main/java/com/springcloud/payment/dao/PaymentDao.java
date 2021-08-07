package com.springcloud.payment.dao;

import com.springcloud.common.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
//@Mapper
public interface PaymentDao {
    public int save(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
    List<Payment> getPayments();
}
