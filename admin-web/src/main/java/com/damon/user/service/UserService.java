package com.damon.user.service;

import java.util.List;

import com.damon.commons.Response;
import com.damon.user.model.SysUser;

/**
 * @author  Damon 
 * @date 2019年8月16日 上午9:38:06
 *
 */

public interface UserService {

	/**
	 * 创建用户
	 * @author Damon 
	 * @date 2019年8月16日
	 *
	 */
	Response<Object> getUserByUsername(String username);

}
