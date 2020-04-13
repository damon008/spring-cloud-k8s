package com.damon.user.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damon.commons.Response;
import com.damon.user.dao.UserMapper;
import com.damon.user.model.SysUser;
import com.damon.user.service.UserService;

/**
 * @author  Damon 
 * @date 2019年8月16日 上午9:40:22
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Response<Object> getUserByUsername(String username) {
		SysUser sysUser = userMapper.getUserByUsername(username);
		if(sysUser!=null && StringUtils.isNotBlank(sysUser.getUserId())) {
			return Response.ok(200, 0, "get user success", sysUser);
		}
		return Response.ok(200, -2, "get user failed", null);
	}
	
}
