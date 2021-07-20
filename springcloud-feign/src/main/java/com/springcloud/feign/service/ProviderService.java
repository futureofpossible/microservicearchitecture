package com.springcloud.feign.service;

import com.springcloud.feign.configuration.FeignConfiguration;
import com.springcloud.feign.service.impl.ProviderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "providerService", value = "eureka-client", fallback = ProviderServiceImpl.class, configuration = FeignConfiguration.class)
public interface ProviderService {
    @RequestMapping(value = "/provider/wantToDone", method = RequestMethod.GET)
    public String wantToDone(@RequestParam("name") String name);
}
