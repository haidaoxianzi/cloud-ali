package com.nacosconf.nacosconfig7777.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gina
 * @Date: 2025-03-12
 * @Description:
 */
@RefreshScope
@RestController
public class ClientConfigController {
    @Value("${config.mybatisInfo}")
    private String mybatisInfo;

    @Value("${config.redisInfo}")
    private String redisInfo;

    @GetMapping("/mybatisInfo")
    public String mybatisInfo() {
        return mybatisInfo;
    }

    @GetMapping("/redisInfo")
    public String redisInfo() {
        return redisInfo;
    }


    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configInfo")
    public String configInfo() {
        return configInfo;
    }
}
