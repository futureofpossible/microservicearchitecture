package com.springcloud.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springcloud.payment.dao")
public class SpringCloudPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPaymentApplication.class, args);
    }
}
