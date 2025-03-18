package com.wq.nacosprovider9001.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: gina
 * @Date: 2025-03-10
 * @Description:
 */
@RestController
@Slf4j
public class UserController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        log.info("........Nacos Provider run...................{}",request.getHeader("X-Request-red"));
        log.info("request.param={}",request.getParameter("are_you_OK"));
        return "9001-----hello Nancy...";
    }
}
