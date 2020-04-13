package com.damon.config;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * 实现自定义负载均衡策略
 * @author Damon 
 * @date 2019年10月30日 上午9:08:49
 *
 */

public class MyProbabilityRandomRule implements IRule {
	
	Logger log = LoggerFactory.getLogger(MyProbabilityRandomRule.class);

	ILoadBalancer balancer = new BaseLoadBalancer();

	@Override
	public Server choose(Object key) {
		List<Server> allServers = balancer.getAllServers();
		Random random = new Random();
		final int number = random.nextInt(10);
		if (number < 7) {
			return findServer(allServers,8091);
		}
		return findServer(allServers,8092);
	}

	private Server findServer(List<Server> allServers, int port) {
		for (Server server : allServers) {
			if (server.getPort() == port) {
				return server;
			}
		}
		log.info("NULL port="+port);
		return null;
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		this.balancer = lb;
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		return this.balancer;
	}

}
