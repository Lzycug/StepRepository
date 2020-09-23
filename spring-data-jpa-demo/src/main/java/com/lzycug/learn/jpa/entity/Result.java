package com.lzycug.learn.jpa.entity;

import java.io.Serializable;

/**
 * description：
 * author：lzyCug
 * date: 2020/9/23 21:19
 */
public class Result<T> implements Serializable {
    private String returnCode;

    private String message;

    private T data;

    public <T> Result() {
    }

    public Result(String code, String msg) {
        this.returnCode = code;
        this.message = msg;
    }

    public Result(String code, String msg, T data) {
        this.returnCode = code;
        this.message = msg;
        this.data = data;
    }

    public static Result ok() {
        return new Result(ResultCode.OK.getCode(), ResultCode.OK.getMsg());
    }

    public static <T> Result ok(T data) {
        return new Result(ResultCode.OK.getCode(), ResultCode.OK.getMsg(), data);
    }

    public static Result error() {
        return new Result(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMsg());
    }

    public static Result error(String code) {
        return new Result(code, ResultCode.getMsgByCode(code));
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result error(String code, T data) {
        return new Result(code, ResultCode.getMsgByCode(code), data);
    }


    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
