package com.damon.commons;


import com.google.common.base.Objects;

import java.io.Serializable;

/**
*
*@author sfwang
*@date 2017年9月12日 下午10:00:55
*
*/
public class ResponseMessage implements Serializable {

	private static final long serialVersionUID = -1779999523580810666L;

    private int status = 200;

    private int code;

    private String message;

    public static final String SUCCESS_MSG = "success";

    public static final String FAILURE_MSG = "failure";

    public static final int SUCCESS_CODE = 0;

    public static final int FAILURE_CODE = -1;

    public ResponseMessage() {
    }

    public ResponseMessage(int status, int code) {
        this.status = status;
        this.code = code;
    }

    public ResponseMessage(int status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public static ResponseMessage ok() {
        return new ResponseMessage(200,SUCCESS_CODE, SUCCESS_MSG);
    }
    
    public static ResponseMessage ok(int code,String message) {
        return new ResponseMessage(200,code, message);
    }
    
    
    public static ResponseMessage ok(int status,int code,String message) {
        return new ResponseMessage(status,code, message);
    }

    public static ResponseMessage error() {
        return new ResponseMessage(200,FAILURE_CODE, FAILURE_MSG);
    }
    
    public static ResponseMessage error(int code,String message) {
        return new ResponseMessage(200,code, message);
    }
    
    
    public static ResponseMessage error(int status,int code,String message) {
        return new ResponseMessage(status,code, message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseMessage that = (ResponseMessage) o;

        return Objects.equal(this.status, that.status) &&
                Objects.equal(this.code, that.code) &&
                Objects.equal(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(status, code, message);
    }

	@Override
	public String toString() {
		return "ResponseMessage [status=" + status + ", code=" + code + ", message=" + message + "]";
	}

}

