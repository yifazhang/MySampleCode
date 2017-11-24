package com.zhangyifa.core.controller.admin;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by zyf on 2017/11/24.
 */
@Controller
@RequestMapping(value = "/control")
public class CenterController {

    @RequestMapping(value = "/test/springmvc.do")
    public String test(String name) {
        System.out.println(name );
        return "";
    }
    //跳转入口页面
    @RequestMapping(value = "/index.do")
    public String index(){
        return "index";
    }
    //跳转头页面
    @RequestMapping(value = "/top.do")
    public String top(){
        return "top";
    }
    //跳转身体页面
    @RequestMapping(value = "/main.do")
    public String main(){
        return "main";
    }
    //跳转左页面
    @RequestMapping(value = "/left.do")
    public String left(){
        return "left";
    }
    //跳转右页面
    @RequestMapping(value = "/right.do")
    public String right(){
        return "right";
    }
}
