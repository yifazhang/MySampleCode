package com.zhangyifa.shopping.web;

import com.zhangyifa.shopping.entity.Content;
import com.zhangyifa.shopping.entity.Page;
import com.zhangyifa.shopping.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zyf on 2017/7/19.
 */
@Controller
public class ContentController {

    @Autowired
    ContentService contentService;

    @RequestMapping({"/","/index"})
    public String index(Integer type , Model model) {
        List<Content> productList = contentService.selectAll();
        model.addAttribute("productList",productList);
        if (type != null && type == 1) {
            model.addAttribute("type",1);
        } else {
            model.addAttribute("type",0);
        }
        System.out.println(productList.toString());
        return "index";
    }


    @RequestMapping(value = "/public")
    public String publicUI() {
        return "public";
    }

    @RequestMapping(value = "/publicSubmit",method = RequestMethod.POST)
    public String publicSubmit(Content content, Model model) {
        try {
            if (content.getImage().length()>0){
                content.setIcon(content.getImage());
            } else {
                content.setIcon(content.getPic());
            }
          int i = contentService.insert(content);
          if (i > 0) {
            model.addAttribute("product",content);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "publicSubmit";
    }

    @RequestMapping("/show")
    public String showDeatail(@RequestParam("id") Long id , Model model) {
        Content product = contentService.selectById(id);
        model.addAttribute("product",product);
        return "show";
    }


}
