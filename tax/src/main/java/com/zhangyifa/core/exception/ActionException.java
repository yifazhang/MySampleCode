package com.zhangyifa.core.exception;

/**
 * Created by zyf on 2017/6/30.
 */
public class ActionException extends SysException {

    public ActionException() {
        super("请求发送错误！");
    }

    public ActionException(String message) {
        super(message);
    }
}
