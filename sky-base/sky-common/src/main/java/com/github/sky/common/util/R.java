
package com.github.sky.common.util;

import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * @Auther: haoxin
 * @Date: 2018-10-15
 * @Description:接口返回包装类
 */
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int SUCCESS = 200;

    public static final int FAIL = 500;

    private String message = "success";

    private int status = SUCCESS;

    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String message) {
        super();
        this.data = data;
        this.message = message;
    }

    public R(Throwable e) {
        super();
        this.message = e.getMessage();
        this.status = FAIL;
    }

    public R(int status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public static R error(int status, String message) {
        R r = new R(status,message);
        return r;
    }

    public static R error(String message) {
        R r = new R(HttpStatus.SC_INTERNAL_SERVER_ERROR,message);
        return r;
    }

    public static R ok() {
        R r = new R();
        return r;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
