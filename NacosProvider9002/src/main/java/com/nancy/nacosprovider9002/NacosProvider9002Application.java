package com.nancy.nacosprovider9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosProvider9002Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider9002Application.class, args);
    }

}
