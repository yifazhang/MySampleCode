package com.zhangyifa.core.controller.admin;

import com.zhangyifa.core.pojo.BbsBrand;
import com.zhangyifa.core.pojo.EUDataGridResult;
import com.zhangyifa.core.service.BrandService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangyifa on 11/25/17.
 */
@Controller
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
        EUDataGridResult pagination = brandService.getItemList(name, display, pageNo, 5);

        model.addAttribute("pagination", pagination);
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
        return "redirect:/brand/list.do";
    }
    
    @RequestMapping(value = "/brand/toEdit.do")
    public String toEdit(int id, ModelMap model) {
    	BbsBrand brand = brandService.getBrandById(id);
    	model.addAttribute("brand", brand);
        return "brand/edit";
    }
    
    @RequestMapping(value = "/brand/edit.do")
    public String edit(BbsBrand brand) {
    	brandService.updateBrand(brand);
        return "redirect:/brand/list.do";
    }
    
    @RequestMapping(value = "/brand/delete.do")
    public String delete(int id,String name,Integer isDisplay,ModelMap model) {
    	brandService.deleteBrand(id);
    	if(StringUtils.isNotBlank(name)){
  			model.addAttribute("name", name);
  		}
  		if(null != isDisplay){
  			model.addAttribute("isDisplay", isDisplay);
  		}
        return "redirect:/brand/list.do";
    }
    
  //删除多个品牌
  	@RequestMapping(value = "/brand/deletes.do")
  	public String deletes(Integer[] ids,String name,Integer isDisplay,ModelMap model){
  		//TODO 删除
  		int count = ids.length;
    	for (int i = 0; i < count; i++) {
			brandService.deleteBrand(ids[i]);
		}
  		if(StringUtils.isNotBlank(name)){
  			model.addAttribute("name", name);
  		}
  		if(null != isDisplay){
  			model.addAttribute("isDisplay", isDisplay);
  		}
  		
  		return "redirect:/brand/list.do";
  	}
    
}
