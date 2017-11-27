package com.zhangyifa.core.controller.admin;

import com.zhangyifa.core.pojo.BbsBrand;
import com.zhangyifa.core.pojo.EUDataGridResult;
import com.zhangyifa.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhangyifa on 11/25/17.
 */
@Controller
@RequestMapping(value = "/control")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/brand/list.do")
    public String list(@RequestParam(defaultValue = "") String name,
                       @RequestParam(defaultValue = "1") int isDisplay,
                       @RequestParam(defaultValue = "1") int pageNo,
                       ModelMap model) {
        Boolean display = true;
        if (isDisplay == 0) {
            display = false;
        }
        EUDataGridResult result = brandService.getItemList(name, display, pageNo, 5);

        model.addAttribute("result", result);
        model.addAttribute("name", name);
        model.addAttribute("isDisplay", isDisplay);

        return "brand/list";
    }
    
    @RequestMapping(value = "/brand/toAdd.do")
    public String toAdd() {
        return "brand/add";
    }
    
    @RequestMapping(value = "/brand/add.do")
    public String add(BbsBrand brand) {
    	brandService.addBrand(brand);
        return "redirect:/control/brand/list.do";
    }
}
