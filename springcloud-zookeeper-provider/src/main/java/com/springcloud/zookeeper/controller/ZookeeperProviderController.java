package com.springcloud.zookeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ZookeeperProviderController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/zk")
    public String zk() {
        return "zookeeper register center,port" + serverPort;
    }
}
