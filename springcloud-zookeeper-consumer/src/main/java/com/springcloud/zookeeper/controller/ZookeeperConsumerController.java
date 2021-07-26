package com.springcloud.zookeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ZookeeperConsumerController {

    public static final String INVOKE_URL = "http://springcloud-zookeeper-provider";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/callByZookeeper")
    public String call() {
        return restTemplate.getForObject(INVOKE_URL + "/zk", String.class);
    }
}
