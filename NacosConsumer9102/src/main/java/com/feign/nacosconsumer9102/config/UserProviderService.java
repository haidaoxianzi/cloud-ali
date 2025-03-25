package com.feign.nacosconsumer9102.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: gina
 * @Date: 2025-03-10
 * @Description:
 */
@FeignClient(value="nacos-provider",fallback = UserProviderServiceImpl.class)
public interface UserProviderService {
    @GetMapping("/hello")
    public String hello();
}
