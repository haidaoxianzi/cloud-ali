package com.feign.nacosconsumer9102.outservice;

import org.springframework.stereotype.Service;

/**
 * @Auther: gina
 * @Date: 2025-03-25
 * @Description:
 */
@Service("userProviderService")
public class UserProviderServiceImpl implements UserProviderService {
    @Override
    public String hello() {
        return "OpenFeign 服务降级..加载拖底数据...";
    }
}
