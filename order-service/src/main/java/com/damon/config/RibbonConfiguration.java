package com.damon.config;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * @author Damon 
 * @date 2019年10月30日 下午5:03:54
 *
 */

public class RibbonConfiguration {

    /**
     * 检查服务是否可用的实例，
     * 此地址返回的响应的返回码如果是200表示服务可用
     * @param config
     * @return
     */
    @Bean
    public IPing ribbonPing(IClientConfig config){
        return new PingUrl();
    }

    /**
     * 轮询规则
     * @param config
     * @return
     */
    @Bean
    public IRule ribbonRule(IClientConfig config){
		//return new AvailabilityFilteringRule();
        return new RoundRobinRule();//轮询
        //return new RetryRule();//重试
		//return new RandomRule();//这里配置策略，和配置文件对应
		//return new WeightedResponseTimeRule();//这里配置策略，和配置文件对应
        //return new BestAvailableRule();//选择一个最小的并发请求的server
        //return new MyProbabilityRandomRule();//自定义
    }
}
