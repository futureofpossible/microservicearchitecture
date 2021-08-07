package com.springcloud.ribbon.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {
    @Bean
    public IRule iRule() {
        //return new RandomRule();
        return new RoundRobinRule();
        //return new WeightedResponseTimeRule();
        //return new ZoneAvoidanceRule();
        //return new BestAvailableRule();
        //return new ZoneAvoidanceRule();
        //return new AvailabilityFilteringRule();
    }
}
