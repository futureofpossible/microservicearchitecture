package com.springcloud.consul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsulConsumerController {
    public static final String INVOKE_URL = "http://springcloud-consul-provider";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getForObject", method = RequestMethod.GET)
    public String getForObject() {
        return restTemplate.getForObject(INVOKE_URL + "/consul/provider", String.class);
    }

    @RequestMapping(value = "/getForEntity", method = RequestMethod.GET)
    public String getForEntity() {
        ResponseEntity<String> entity = restTemplate.getForEntity(INVOKE_URL + "/consul/provider", String.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return "failure";
        }
    }
}
