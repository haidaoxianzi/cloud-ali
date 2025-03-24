package com.wq.nacosconsumer9101.controller;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: gina
 * @Date: 2025-03-24
 * @Description:热点规则
 */
@RestController
@Slf4j
public class HotRuleController {

    /**
     * 热点规则，案例1:基本配置测试
     */
    @GetMapping("/hotRuleDemo1")
    @SentinelResource(value = "hotRuleDemo1", blockHandler = "handlerHotKey")
    public String hotRuleDemo1(@RequestParam(value = "hotParam1", required = false) String hotParam1,
                               @RequestParam(value = "hotParam2", required = false) String hotParam2,
                               @RequestParam(value = "hotParam3", required = false) String hotParam3) throws InterruptedException {

        log.info("-----hotRuleDemo1---");
        Thread.sleep(100);
        return "ok";
    }

    public String handlerHotKey(String hotParam1, String hotParam2, String hotParam3, BlockException blockException) throws InterruptedException {

        log.info("-----handlerHotKey---blockException");
        blockException.printStackTrace();
        return "系统过于繁忙，请您稍后重试";
    }
}
