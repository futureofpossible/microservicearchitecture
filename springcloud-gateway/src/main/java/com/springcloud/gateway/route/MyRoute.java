package com.springcloud.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRoute {
    @Bean
    public RouteLocator internationalRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("international_route", r -> r.path("/guoji/**")
                        .uri("https://news.baidu.com/guoji")).build();
    }
    @Bean
    public RouteLocator domesticRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("domestic_route", r -> r.path("/guonei/**")
                        .uri("https://news.baidu.com/guonei")).build();
    }
}
