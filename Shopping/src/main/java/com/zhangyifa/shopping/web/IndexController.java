package com.zhangyifa.shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zyf on 2017/7/19.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        System.out.println("index -------- ");
        return "index";
    }
}
