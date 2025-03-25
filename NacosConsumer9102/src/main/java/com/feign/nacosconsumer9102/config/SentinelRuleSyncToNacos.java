package com.feign.nacosconsumer9102.config;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
/*import com.alibaba.csp.sentinel.datasource.nacos.NacosWritableDataSource;*/
import com.alibaba.csp.sentinel.property.SentinelProperty;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
/*import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;*/

import java.util.List;

/**
 * @Auther: gina
 * @Date: 2025-03-25
 * @Description:
 */
public class SentinelRuleSyncToNacos {

    private static final String GROUP_ID = "SENTINEL_GROUP";
    private static final String DATA_ID = "sentinel-flow-rules";
    private static final String SERVER_ADDR = "localhost:8848";

    public static void initSync() {
        // 读取数据源
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(
                SERVER_ADDR, GROUP_ID, DATA_ID,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {})
        );
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());

    /*    // 写入数据源
        WritableDataSource<List<FlowRule>> flowRuleWritableDataSource =null;
        new NacosWritableDataSource<>( SERVER_ADDR, GROUP_ID, DATA_ID,
                rules -> JSON.toJSONString(rules, true));

        SentinelProperty<List<FlowRule>> property;
        FlowRuleManager.register2Property(flowRuleWritableDataSource.getProperty());*/
    }
}
