package com.nacosconf.nacosconfig7777;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfig7777Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig7777Application.class, args);
    }

}
