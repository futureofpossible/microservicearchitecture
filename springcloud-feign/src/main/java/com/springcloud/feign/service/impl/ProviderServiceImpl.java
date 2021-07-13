package com.springcloud.feign.service.impl;

import com.springcloud.feign.service.ProviderService;
import org.springframework.stereotype.Component;

@Component
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String wantToDone(String name) {
        return "service is closed";
    }
}
