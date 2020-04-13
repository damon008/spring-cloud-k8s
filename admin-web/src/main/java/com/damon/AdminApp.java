package com.damon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.damon.config.EnvConfig;

/**
 * @author Damon 
 * @date 2020年1月13日 下午3:23:06
 *
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.damon"})
@EnableConfigurationProperties(EnvConfig.class)
@EnableDiscoveryClient
public class AdminApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }

}
