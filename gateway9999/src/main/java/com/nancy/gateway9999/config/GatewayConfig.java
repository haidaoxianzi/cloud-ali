package com.nancy.gateway9999.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: gina
 * @Date: 2025-03-16
 * @Description: 配置gateway路由
 */
//@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        //获取构建多个路由的routes
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("nacos-provider1", r -> r.path("/nacos-provider/**")
                .uri("http://172.18.101.197:9001/nacos-provider"));
        return routes.build();
    }
}










































