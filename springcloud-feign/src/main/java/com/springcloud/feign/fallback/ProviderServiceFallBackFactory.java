package com.springcloud.feign.fallback;

import com.springcloud.feign.service.ProviderService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProviderServiceFallBackFactory implements FallbackFactory<ProviderService> {
    @Override
    public ProviderService create(Throwable throwable) {
        /*return new ProviderService() {
            @Override
            public String wantToDone(String name) {
                log.error("执行wantToDone方法参数：{},服务降级{}", name, throwable);
                return "exception";
            }
        };*/
        return (name) -> {
            log.error("执行wantToDone方法参数：{},服务降级{}", name, throwable);
            return "exception";
        };
    }
}
