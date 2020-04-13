package com.damon.user.dao;

import org.springframework.stereotype.Repository;

import com.damon.user.model.SysUser;

/**
*
*
* created by Damon
* 2018年5月23日 下午4:05:21
*
*/
@Repository
public interface UserMapper {
	
	SysUser getUserByUsername(String username);

	SysUser login(String username, String password);

	int updatePwd(String username, String enCodeByMD5);
	
}
