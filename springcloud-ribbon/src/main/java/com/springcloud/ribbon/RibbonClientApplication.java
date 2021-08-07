package com.springcloud.ribbon;

import com.springcloud.ribbon.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
//@RibbonClient(name = "SPRINGCLOUD-PAYMENTSERVICE",configuration = MyRule.class)
public class RibbonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApplication.class,args);
    }
    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
