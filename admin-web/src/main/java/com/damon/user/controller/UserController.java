package com.damon.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damon.commons.Response;
import com.damon.user.service.UserService;

/**
 * 
 * 
 * @author Damon 
 * @date 2020年1月13日 下午3:31:07
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/getUserInfo")
    public Response<Object> getUserInfo() {
		return userService.getUserByUsername("damon");
    }

}
