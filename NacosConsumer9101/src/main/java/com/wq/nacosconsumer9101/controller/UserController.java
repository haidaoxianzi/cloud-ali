package com.wq.nacosconsumer9101.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wq.nacosconsumer9101.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Date;
/**
 * @Auther: gina
 * @Date: 2025-03-10
 * @Description:
 */
@RestController
@Slf4j
public class UserController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Autowired
    private CouponService couponService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/helloConsumer")
    public String helloProvider() {
        log.info("------消费者接口执行----");
        //restTemplate实现服务发现和调用
        return restTemplate.getForObject(serverUrl + "/hello", String.class);
    }

    @GetMapping("/sentinelDemo")
    public String sentinelDemo() throws InterruptedException {
        log.info("------消费者接口执行----consumer--9101----sentinelDemo1");
        Thread.sleep(500);
        return "ok";
    }

    /**
     * 支付做限流阈值
     */
    @GetMapping("/payOrder")
    public String payOrder() throws InterruptedException {
        log.info("9101-支付接口---支付接口设置阈值");
        couponService.couponList();
        Thread.sleep(200);
        return "ok";
    }

    /*
     * 支付接口达到阈值，下订单会被限流。
     * 【流控规则的】流控模式为 关联模式
     * */
    @GetMapping("/createOrder")
    public String createOrder() throws InterruptedException {
        log.info("9101-创单接口---达到支付接口的阈值后，关联的创单接口会被限流");
        couponService.couponList();
        Thread.sleep(300);
        return "ok";
    }

    /**
     * 秒杀活动，设置预热的流控规则
     */
    @GetMapping("/secKill")
    public String secKill() throws InterruptedException {
        log.info("---secKill---流控模式为 预热");
        Thread.sleep(200);
        return "ok";
    }

    /**
     * 流控规则：流控模式为排队等待
     */
    @GetMapping("/waiting")
    public String waiting() throws InterruptedException {
        log.info("waiting---流控模式为排队等待 ，时间：" + (new Date()));
        Thread.sleep(200);
        return "ok";
    }

    /**
     * 熔断策略：异常比例
     */
    @GetMapping("/rongDuan")
    public String rongDuan(Integer id) throws InterruptedException {
        log.info("------消费者接口执行----consumer--9101----sentinelDemo1");
        Thread.sleep(500);
        if (id != null && id > 66) {
            throw new RuntimeException("异常比例测试");
        }
        return "ok";
    }

    @GetMapping("/abTest")
    @SentinelResource(value = "version_A")
    public String versionB() throws InterruptedException {
        return "version_A--9101";
    }
}
