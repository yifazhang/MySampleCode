package com.zhangyifa.core.exception;

/**
 * Created by zyf on 2017/6/30.
 */
public class ServiceException extends SysException {

    public ServiceException() {
        super("业务操作错误! ");
    }

    public ServiceException(String message) {
        super(message);
    }
}
