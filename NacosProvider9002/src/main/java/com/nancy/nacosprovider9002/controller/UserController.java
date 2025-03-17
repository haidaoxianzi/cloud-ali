package com.nancy.nacosprovider9002.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gina
 * @Date: 2025-03-10
 * @Description:
 */
@RestController
@Slf4j
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        log.info("........Nacos Provider run...................");
        return "9002-----hello Nancy...";
    }
}
