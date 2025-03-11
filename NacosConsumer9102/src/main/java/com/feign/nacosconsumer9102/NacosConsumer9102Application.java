package com.feign.nacosconsumer9102;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients(basePackages = "com.feign.nacosconsumer9102.config")
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumer9102Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer9102Application.class, args);
    }
}
