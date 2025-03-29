package com.wq.nacosconsumer9101.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gina
 * @Date: 2025-03-29
 * @Description:
 */
@RestController
public class DemoController {

    @GetMapping("/testV1")
    public String testV1() {
        return "test...API..V1...";
    }


    @GetMapping("/testV2")
    public String testV2() {
        return "test...API..V2...";
    }



}
