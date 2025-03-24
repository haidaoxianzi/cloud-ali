package com.wq.nacosconsumer9101.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wq.nacosconsumer9101.handler.CustomSentinelHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: gina
 * @Date: 2025-03-24
 * @Description:热点规则
 */
@RestController
@Slf4j
public class HotRuleController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;

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

    /**
     * 测试
     * 自定义通用限流处理
     */
    @GetMapping("/customBlockHandleTest")
    @SentinelResource(value = "customBlockHandleTest", blockHandlerClass = CustomSentinelHandler.class, blockHandler = "handlerException1")
    public String customBlockHandleTest() throws InterruptedException {
        log.info("------自定义通用限流处理 测试");
        Thread.sleep(200);
        return "ok";
    }

    /**
     * 通过Ribbon调用远程服务的时候，如果服务超时或者网络问题调不到，
     * 可以通过fallback做拖底， 给一些拖底数据
     */
    @GetMapping("/helloConsumer2")
    @SentinelResource(value = "helloConsumer", fallback = "fallBackHandler",
            blockHandler = "flowLimitHandler",
            exceptionsToIgnore = {NullPointerException.class})//标注的异常会原样抛出
    public String helloConsumer() {
        log.info("消费者接口9101基于ribbon ，通过restTemplate 做的远程服务调用,调远程服务9001资源：/hello");
        return restTemplate.getForObject(serverUrl + "/hello", String.class);
    }

    /**
     * 保证方法签名基本保持一致，但是要添加异常类型参数
     */
    public String fallBackHandler(Throwable throwable) {
        return "返回拖底数据";
    }

    /**
     * 限流后的处理逻辑
     */
    public String flowLimitHandler() {
        return "系统繁忙请稍后重试～";
    }


}
