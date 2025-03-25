package com.feign.nacosconsumer9102.config;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2025-03-25
 * @Description:
 */
public class SentinelNacosConfig {
    private static final String GROUP_ID = "SENTINEL_GROUP";
    private static final String DATA_ID = "sentinel-flow-rules";
    private static final String SERVER_ADDR = "localhost:8848";

    public static void initNacosDataSource() {
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(SERVER_ADDR, GROUP_ID, DATA_ID,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }
}
