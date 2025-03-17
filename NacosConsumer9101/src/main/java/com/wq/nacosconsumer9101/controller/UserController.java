package com.wq.nacosconsumer9101.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @Auther: gina
 * @Date: 2025-03-10
 * @Description:
 */
@RestController
@Slf4j
public class UserController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/helloConsumer")
    public String helloProvider() {
        log.info("------消费者接口执行----");
        //restTemplate实现服务发现和调用
        return restTemplate.getForObject(serverUrl+"/hello",String.class);
    }
}
