package com.wq.nacosconsumer9101.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gina
 * @Date: 2025-03-24
 * @Description:系统保护
 */
@RestController
public class SystemProtectController {
    @GetMapping("/sysProtectDemo")
    public String systemProtectDemo(){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }
}
