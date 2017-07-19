package com.zhangyifa.shopping.entity;

/**
 * Created by zyf on 2017/7/19.
 */
public class Result {

    private int code;
    private String message;
    private Boolean result;

    public Result() {
    }

    public Result(int code, String message, Boolean result) {
        this.code = code;
        this.message = message;
        this.result = result;
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

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
