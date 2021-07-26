package com.springcloud.payment.controller;

import com.springcloud.common.entity.CommonResult;
import com.springcloud.common.entity.Payment;
import com.springcloud.payment.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pay")
@Slf4j
public class PayController {
    //    private static final Logger logger = Logger.getLogger(PayController.class);
    @Autowired
    private PayService payService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/addPayment")
    public CommonResult addPayment(@RequestHeader("User-Agent") String userAgent, @RequestBody Payment payment) {
        int i = payService.savePayment(payment);
        CommonResult<Payment> commonResult = new CommonResult<>();
        log.info("调用端口为" + serverPort + "的支付服务");
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

    @RequestMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENTSERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "," + instance.getInstanceId() + "," + instance.getHost() + "," + instance.getPort() + "," + instance.getUri());
        }
        return this.discoveryClient;
    }
}
