package com.damon.commons;

import com.google.common.base.Objects;

/**
* @Desc 响应结果
* @author Damon
* @date 2017年3月15日 下午12:59:23
*
*/
public class Response<T> {

    /**
     * 接口操作返回信息
     */
    protected ResponseMessage message;

    /**
     * 数据
     */
    protected T data;

    public Response() {
        this(null, null);
    }

    public Response(T data) {
        this(null, data);
    }

    public Response(ResponseMessage message) {
        this.message = message;
    }

    public Response(ResponseMessage message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResponseMessage getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response<?> that = (Response<?>) o;

        return Objects.equal(this.message, that.message) &&
                Objects.equal(this.data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message, data);
    }

    @Override
	public String toString() {
		return "Response [message=" + message + ", data=" + data + "]";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Response<Void> ok() {
        return new Response(ResponseMessage.ok(), null);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Response<T> ok(T data) {
        return new Response(ResponseMessage.ok(), data);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Response<Void> ok(int status,int code,String message) {
        return new Response(ResponseMessage.ok(status,code,message), null);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Response<T> ok(int status,int code,String message, T data) {
        return new Response(ResponseMessage.ok(status,code,message), data);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Response<Void> error() {
        return new Response(ResponseMessage.error(), null);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Response<T> error(T data) {
        return new Response(ResponseMessage.error(), data);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Response<Void> error(int status,int code,String message) {
        return new Response(ResponseMessage.error(status,code,message), null);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Response<T> error(int status,int code,String message, T data) {
        return new Response(ResponseMessage.error(status,code,message), data);
    }

	public void setMessage(ResponseMessage message) {
		this.message = message;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    
}

