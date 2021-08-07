package com.springcloud.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/hiService", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "error")
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/provider/wantToDone?name=" + name, String.class);
    }

    @RequestMapping(value = "/helloService", method = RequestMethod.GET)
    public String helloService(String name) {
        ServiceInstance instance = loadBalancerClient.choose("EUREKA-CLIENT");
        return restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/provider/wantToDone?name=" + name, String.class);
    }

    public String error(String name) {
        return "hi," + name + ",service is unavailable!";
    }

    @GetMapping(value = "/callPaymentService/{id}")
    public String callPayment(@PathVariable("id") Long id) {
//        ServiceInstance instance = loadBalancerClient.choose("SPRINGCLOUD-PAYMENTSERVICE");
//        return restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/pay/getPaymentById/" + id, String.class);
        return restTemplate.getForObject("http://SPRINGCLOUD-PAYMENTSERVICE/pay/getPaymentById/" + id, String.class);
    }
}
