package com.wq.nacosprovider9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosProvider9001Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider9001Application.class, args);
    }

}
