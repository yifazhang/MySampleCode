package com.zhangyifa.core.exception;

/**
 * Created by zyf on 2017/6/30.
 */
public class SysException extends Exception {

    private String errorMsg;

    public SysException() {
        super();
    }

    public SysException(String message) {
        super(message);
        errorMsg = message;
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
        errorMsg = message;
    }

    public SysException(Throwable cause) {
        super(cause);
    }

    protected SysException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
