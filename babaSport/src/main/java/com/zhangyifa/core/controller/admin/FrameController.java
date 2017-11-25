package com.zhangyifa.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangyifa on 11/25/17.
 */
@Controller
@RequestMapping(value = "/control")
public class FrameController {

    @RequestMapping(value = "/frame/product_main.do")
    public String productMain() {
        return "frame/product_main";
    }

    @RequestMapping(value = "/frame/order_main.do")
    public String orderMain() {
        return "frame/order_main";
    }

    @RequestMapping(value = "/frame/product_left.do")
    public String productLeft() {
        return "frame/product_left";
    }

    @RequestMapping(value = "/frame/order_left.do")
    public String orderLeft() {
        return "frame/order_left";
    }
}
