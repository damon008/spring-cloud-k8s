package com.damon.order.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.damon.commons.Response;

/**
 * @author Damon 
 * @date 2020年3月13日 下午2:26:17
 *
 */

public interface OrderService {
	
	Response<Object> getUserInfo(HttpServletRequest req, HttpServletResponse res);
}
