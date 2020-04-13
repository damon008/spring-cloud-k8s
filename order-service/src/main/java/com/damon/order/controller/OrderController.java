package com.damon.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damon.commons.Response;
import com.damon.order.service.OrderService;

import cn.hutool.core.util.StrUtil;

/**
 * 
 * 
 * @author Damon 
 * @date 2020年1月13日 下午3:31:07
 *
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
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
    @GetMapping(value = "/getUserInfo")
	public Response<Object> getUserInfo(HttpServletRequest req, HttpServletResponse res) {
		Response<Object> userInfo = orderService.getUserInfo(req, res);
		return userInfo;
	}

}
