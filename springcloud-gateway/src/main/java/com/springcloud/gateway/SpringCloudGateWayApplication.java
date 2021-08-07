package com.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 路由Route 断言Predicate 过滤器Filter
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGateWayApplication.class,args);
    }
}
