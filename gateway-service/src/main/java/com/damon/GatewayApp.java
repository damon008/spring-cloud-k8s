package com.damon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * Gateway
 * @author Damon 
 * @date 2020年1月14日 上午9:54:54
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.damon"})
//@SpringBootApplication(scanBasePackages = { "com.damon" })
@EnableDiscoveryClient
public class GatewayApp {
	
	public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }
}
