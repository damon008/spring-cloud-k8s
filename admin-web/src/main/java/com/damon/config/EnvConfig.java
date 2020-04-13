package com.damon.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置信息
 * @author Damon 
 * @date 2019年10月25日 下午1:54:01
 *
 */

@Configuration
@ConfigurationProperties(prefix = "greeting")
public class EnvConfig {

    private String message = "This is a dummy message";
    
    private String spring_mq_host;
    private String spring_mq_port;
    private String spring_mq_user;
    private String spring_mq_pwd;
    private String jdbc_driverClassName;
    private String jdbc_url;
    private String jdbc_username;
    private String jdbc_password;
    private String spring_redis_host;
    private String spring_redis_port;
    private String spring_redis_pwd;
    private String base_path;
    private String chunk_size;
    private Long expire_time= 600000L;
    
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


	public String getSpring_mq_host() {
		return spring_mq_host;
	}

	public void setSpring_mq_host(String spring_mq_host) {
		this.spring_mq_host = spring_mq_host;
	}

	public String getSpring_mq_port() {
		return spring_mq_port;
	}

	public void setSpring_mq_port(String spring_mq_port) {
		this.spring_mq_port = spring_mq_port;
	}

	public String getSpring_mq_user() {
		return spring_mq_user;
	}

	public void setSpring_mq_user(String spring_mq_user) {
		this.spring_mq_user = spring_mq_user;
	}

	public String getSpring_mq_pwd() {
		return spring_mq_pwd;
	}

	public void setSpring_mq_pwd(String spring_mq_pwd) {
		this.spring_mq_pwd = spring_mq_pwd;
	}

	public String getJdbc_driverClassName() {
		return jdbc_driverClassName;
	}

	public void setJdbc_driverClassName(String jdbc_driverClassName) {
		this.jdbc_driverClassName = jdbc_driverClassName;
	}

	public String getJdbc_url() {
		return jdbc_url;
	}

	public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}

	public String getJdbc_username() {
		return jdbc_username;
	}

	public void setJdbc_username(String jdbc_username) {
		this.jdbc_username = jdbc_username;
	}

	public String getJdbc_password() {
		return jdbc_password;
	}

	public void setJdbc_password(String jdbc_password) {
		this.jdbc_password = jdbc_password;
	}

	public String getSpring_redis_host() {
		return spring_redis_host;
	}

	public void setSpring_redis_host(String spring_redis_host) {
		this.spring_redis_host = spring_redis_host;
	}

	public String getSpring_redis_port() {
		return spring_redis_port;
	}

	public void setSpring_redis_port(String spring_redis_port) {
		this.spring_redis_port = spring_redis_port;
	}

	public String getSpring_redis_pwd() {
		return spring_redis_pwd;
	}

	public void setSpring_redis_pwd(String spring_redis_pwd) {
		this.spring_redis_pwd = spring_redis_pwd;
	}


	public String getBase_path() {
		return base_path;
	}

	public void setBase_path(String base_path) {
		this.base_path = base_path;
	}

	public String getChunk_size() {
		return chunk_size;
	}

	public void setChunk_size(String chunk_size) {
		this.chunk_size = chunk_size;
	}

	public Long getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(Long expire_time) {
		this.expire_time = expire_time;
	}
	
    
}
