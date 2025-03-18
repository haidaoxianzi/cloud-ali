package com.nancy.gateway9999.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Auther: gina
 * @Date: 2025-03-18
 * @Description:
 */
@Component
@Slf4j
public class MyFilter implements Ordered, GlobalFilter {
    /*
     *
     * */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //pre处理
        String str = exchange.getRequest().getQueryParams().getFirst("userName");

        if (StringUtils.isEmpty(str)) {
            log.info("请求非法：userName is null");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();//设置响应完成，这个位置拦截了请求
        }
        Mono<Void> mono = chain.filter(exchange);//正常放行
        //post处理

        return mono;
    }

    /*
     * 该过滤器在整个过滤器链中加载顺序
     * 数字越小，优先级越高
     * */
    @Override
    public int getOrder() {
        return 0;
    }
}
