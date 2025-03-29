package com.feign.nacosconsumer9102.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.feign.nacosconsumer9102.outservice.UserProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gina
 * @Date: 2025-03-10
 * @Description:
 */
@RestController
public class UserController {

    @Qualifier(value = "userProviderService")
    @Autowired
    private UserProviderService userProviderService;

    @SentinelResource(value = "helloOpenFeign")
    @GetMapping("/helloOpenFeign")
    public String helloOpenFeign() {
        return userProviderService.hello();
    }

    @GetMapping("/order/test1")
    @SentinelResource(value = "test1")
    public String test1() throws InterruptedException {
        return "test1";
    }

    @GetMapping("/abTest")
    @SentinelResource(value = "version-b")
    public String versionB() throws InterruptedException {
        return "version_B--9102";
    }
}
