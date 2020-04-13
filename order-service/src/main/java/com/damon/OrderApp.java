package com.damon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.damon.config.EnvConfig;

/**
 * @author Damon 
 * @date 2020年1月13日 下午3:23:06
 *
 */

@Configuration//@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.damon"})
@EnableConfigurationProperties(EnvConfig.class)
@EnableDiscoveryClient
@EnableCircuitBreaker//@EnableHystrix

//@RibbonClients针对多个服务源进行策略的指定 ,这里注意这种方式时，RibbonConfiguration类不能被包含在@ComponentScan的扫描包中
/*@RibbonClients(value = {
		@RibbonClient(name="cas-server-service", configuration = RibbonConfiguration.class),
		@RibbonClient(name="admin-web-service", configuration = RibbonConfiguration.class)
})*/
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

}
