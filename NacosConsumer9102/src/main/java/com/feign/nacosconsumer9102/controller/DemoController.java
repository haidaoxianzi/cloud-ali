package com.feign.nacosconsumer9102.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gina
 * @Date: 2025-03-29
 * @Description:
 */
@RestController
public class DemoController {

    @GetMapping("/testV2")
    public String testV2() {
        return "testV2...";
    }

}
