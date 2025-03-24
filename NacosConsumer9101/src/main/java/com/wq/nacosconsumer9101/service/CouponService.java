package com.wq.nacosconsumer9101.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther: gina
 * @Date: 2025-03-23
 * @Description:
 */
@Service
@Slf4j
public class CouponService {

    @SentinelResource("couponList")  //标识为公共资源
    public void couponList() {
        log.info("couponList is invoke");
    }
}
