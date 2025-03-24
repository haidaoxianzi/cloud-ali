package com.wq.nacosconsumer9101.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Auther: gina
 * @Date: 2025-03-24
 * @Description:自定义流式处理器
 */
public class CustomSentinelHandler {

    public static String handlerException1(BlockException exception) {
        return "handlerException1:系统异常，请稍后重试 ";
    }

    public static String handlerException2(BlockException exception){
        return "handlerException2:系统繁忙，请稍后重试";
    }
}
