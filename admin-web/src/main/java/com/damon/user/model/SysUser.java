package com.damon.user.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

public class SysUser implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2426438324837204802L;

	private Long id;
	
    private Integer isAdmin;
    
    private String userId;

    private String userType;

    private String username;
    
    private String realName;

    private String password;

    private String phone;

    private String email;

    private String createBy;

    private Long createTime;

    private String updateBy;

    private Long updateTime;
    
    private Long loginTime;
    
    private Long expireTime;

    private String remarks;

    private Integer delFlag;
    
    private Integer loginType;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getLoginType() {
		return loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}
	

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public Long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	
	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}
	
	public SysUser() {
		super();
	}
	
	public SysUser(Long id, Integer isAdmin, String userId, String userType, String username, String realName,
			String password, String phone, String email, String createBy, Long createTime, String updateBy,
			Long updateTime, Long loginTime, Long expireTime, String remarks, Integer delFlag, Integer loginType) {
		super();
		this.id = id;
		this.isAdmin = isAdmin;
		this.userId = userId;
		this.userType = userType;
		this.username = username;
		this.realName = realName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.loginTime = loginTime;
		this.expireTime = expireTime;
		this.remarks = remarks;
		this.delFlag = delFlag;
		this.loginType = loginType;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", isAdmin=" + isAdmin + ", userId=" + userId + ", userType=" + userType
				+ ", username=" + username + ", realName=" + realName + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy="
				+ updateBy + ", updateTime=" + updateTime + ", loginTime=" + loginTime + ", expireTime=" + expireTime
				+ ", remarks=" + remarks + ", delFlag=" + delFlag + ", loginType=" + loginType + "]";
	}

}