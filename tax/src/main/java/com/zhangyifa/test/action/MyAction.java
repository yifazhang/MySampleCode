package com.zhangyifa.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhangyifa.test.service.MyService;

import javax.annotation.Resource;

/**
 * Created by zhangyifa on 6/26/17.
 */
public class MyAction extends ActionSupport {

    @Resource
    MyService myServicel;

    public String execute() throws Exception {
        myServicel.say();
        return SUCCESS;
    }
}
