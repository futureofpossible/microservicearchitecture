package com.springcloud.payment.controller;

import com.springcloud.common.entity.CommonResult;
import com.springcloud.common.entity.Payment;
import com.springcloud.payment.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pay")
public class PayController {
//    private static final Logger logger = Logger.getLogger(PayController.class);
    @Autowired
    private PayService payService;

    @PostMapping(value = "/addPayment")
    public CommonResult addPayment(@RequestHeader("User-Agent") String userAgent, @RequestBody Payment payment) {
        int i = payService.savePayment(payment);
        CommonResult<Payment> commonResult = new CommonResult<>();
        if (i > 0) {
            commonResult.setCode(200);
            commonResult.setMessage("success");
        } else {
            commonResult.setCode(200);
            commonResult.setMessage("failure");
        }
        return commonResult;
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = payService.getPaymentById(id);
        CommonResult<Payment> commonResult = new CommonResult<>();
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(200, "没有对应记录", null);
        }
    }
}