package com.springcloud.order.controller;

import com.springcloud.common.entity.CommonResult;
import com.springcloud.common.entity.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/remoteCallPay")
    public CommonResult serviceToServiceCalls(@RequestBody Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/pay/addPayment", payment, CommonResult.class);
        return commonResult;
    }

}
