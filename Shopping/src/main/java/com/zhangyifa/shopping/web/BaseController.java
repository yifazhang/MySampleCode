package com.zhangyifa.shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * Created by zyf on 2017/7/18.
 */
@Controller
@RequestMapping("/base")
public class BaseController {

    @Resource
    ServletContext application;

    @RequestMapping("/goURL/{folder}/{file}")
    public String goURL(@PathVariable String folder, @PathVariable String file) {
        return "forward:/template/" +folder+"/"+file;
    }

    @RequestMapping("/goURL/{file}")
    public String goOneURL( @PathVariable String file) {
        return "forward:/template/"+file;
    }

}
