package com.nancy.gateway9999;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Gateway9999Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9999Application.class, args);
    }

}
