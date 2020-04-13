package com.damon.order.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.damon.commons.Response;
import com.damon.config.EnvConfig;
import com.damon.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.StrUtil;

/**
 * @author Damon 
 * @date 2020年3月13日 下午2:26:51
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
    private EnvConfig envConfig;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;

	//@HystrixCommand(fallbackMethod = "admin_service_fallBack")
	//@HystrixCommand(fallbackMethod = "admin_service_fallBack", commandProperties = {
			//@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })//隔离策略:execution.isolation.strategy =SEMAPHORE or THREAD(默认)
	//如果不加@HystrixCommand的commandProperties=@HystrixProperty注解配置，下面的请求是一个线程；@HystrixCommand()是一个隔离线程。
	//加上@HystrixCommand的commandProperties=@HystrixProperty注解配置后，将2个线程合并到一个线程里。
	/*@Override
	public Response<Object> getUserInfo(HttpServletRequest req, HttpServletResponse res) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		headers.add("Authorization", "bearer " + StrUtil.subAfter(req.getHeader("Authorization"), "bearer ", false));
		HttpEntity<String> formEntity = new HttpEntity<String>(null, headers);
		String body = "";
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(envConfig.getAdmin_web_url() + "/api/user/getUserInfo",
					HttpMethod.GET, formEntity, String.class);
			if (responseEntity.getStatusCodeValue() == 200) {
				logger.debug(String.format("request getUserInfo return: {}", JSON.toJSON(responseEntity.getBody())));
				return Response.ok(responseEntity.getStatusCodeValue(), 0, "success", JSON.toJSON(responseEntity.getBody()));
			}
		} catch (Exception e) {
			logger.error("loadJobDetail error");
			logger.error(e.getMessage(), e);
		}
		return null;
		
	}*/
	
	
	/**
	 * 
	 * 服务内调用其他服务 demo
	 * @param req
	 * @param res
	 * @return
	 * @author Damon 
	 * @date 2020年4月1日
	 *
	 */
	//@HystrixCommand(fallbackMethod="admin_service_fallBack",commandKey="getUserInfo2")//默认与其方法名getUserInfo一样
	@HystrixCommand(fallbackMethod = "admin_service_fallBack")
	@Override
	public Response<Object> getUserInfo(HttpServletRequest req, HttpServletResponse res) {
		
        HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<String> formEntity = new HttpEntity<String>(null, headers);
		String body = "";
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(envConfig.getAdmin_web_url() + "/api/user/getUserInfo",
					HttpMethod.GET, formEntity, String.class);
			if (responseEntity.getStatusCodeValue() == 200) {
				logger.debug(String.format("request getUserInfo return: {}", JSON.toJSON(responseEntity.getBody())));
				return Response.ok(responseEntity.getStatusCodeValue(), 0, "success", JSON.toJSON(responseEntity.getBody()));
			}
		} catch (Exception e) {
			logger.error("loadJobDetail error");
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 熔断时调用的方法
	 * 
	 * 参数要与被请求的方法的参数一致
	 * 
	 * @return
	 */
	private Response<Object> admin_service_fallBack(HttpServletRequest req, HttpServletResponse res) {
		String token = StrUtil.subAfter(req.getHeader("Authorization"), "bearer ", false);
		logger.info("admin_service_fallBack token: {}", token);
		return Response.ok(200, -1, "用戶服務掛啦!", null);
	}
	
	
}
