package com.feign.nacosconsumer9102.controller;

import com.feign.nacosconsumer9102.config.UserProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gina
 * @Date: 2025-03-10
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserProviderService userProviderService;

    @GetMapping("/helloOpenFeign")
    public String helloOpenFeign(){
        return userProviderService.hello();
    }

}
