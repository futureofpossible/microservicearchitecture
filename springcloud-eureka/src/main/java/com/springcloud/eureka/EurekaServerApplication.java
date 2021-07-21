package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 调度协调管理 服务治理 服务注册中心 存放服务地址相关信息即接口地址 服务消费者 Eureka集群 服务提供者集群  维持心跳 一对多 Register/Renew/Cancel 监控系统中各个微服务是否正常运行
 * 服务通讯地址以别名方式注册到注册中心 本地RPC调用远程RPC
 * 单机 单点故障 集群环境搭建
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}