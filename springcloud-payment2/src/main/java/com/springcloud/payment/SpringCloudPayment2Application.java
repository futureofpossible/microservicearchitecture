package com.springcloud.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.springcloud.payment.dao")
@EnableEurekaClient
public class SpringCloudPayment2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPayment2Application.class, args);
    }
}
