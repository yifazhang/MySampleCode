package com.zhangyifa.shopping.web;

import com.zhangyifa.shopping.dto.ProductDTO;
import com.zhangyifa.shopping.entity.Content;
import com.zhangyifa.shopping.entity.DealRecord;
import com.zhangyifa.shopping.entity.Person;
import com.zhangyifa.shopping.entity.Result;
import com.zhangyifa.shopping.service.ContentService;
import com.zhangyifa.shopping.service.DealRecordService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zyf on 2017/7/19.
 */
@Controller
public class ContentController {

    @Autowired
    ContentService contentService;

    @Autowired
    DealRecordService dealRecordService;

    @RequestMapping({"/", "/index"})
    public String index(Integer type, Model model, HttpSession session) {
        List<Content> productList = contentService.selectAll();
        List<ProductDTO> endList = new ArrayList<>();
        for (Content c : productList) {
            ProductDTO p = setProductDTOData(c, session);
            endList.add(p);
        }

        model.addAttribute("productList", endList);

        if (type != null && type == 1) {
            model.addAttribute("type", 1);
        } else {
            model.addAttribute("type", 0);
        }
        model.addAttribute("title", "首页");
        return "index";
    }

    @RequestMapping(value = "/public")
    public String publicUI() {
        return "public";
    }

    @RequestMapping(value = "/publicSubmit", method = RequestMethod.POST)
    public String publicSubmit(Content content, Model model) {
        try {
            int i = contentService.insert(content);
            if (i > 0) {
                model.addAttribute("product", content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "publicSubmit";
    }

    @RequestMapping("/edit")
    public String contentEdit(@RequestParam("id") Integer id, Model model) {
        Content product = contentService.selectById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @RequestMapping("/editSubmit")
    public String contentEditSubmit(@RequestParam("id") Integer id, Content content, Model model) {
        content.setId(id);
        Content product = null;
        try {
            Integer i = contentService.update(content);
            if (i > 0) {
                model.addAttribute("product", content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "editSubmit";
    }

    @RequestMapping("/show")
    public String showDeatail(@RequestParam("id") Long id, Model model, HttpSession session) {

        Content c = contentService.selectById(id);
        ProductDTO p = setProductDTOData(c, session);
        model.addAttribute("product", p);
        return "show";
    }

    @RequestMapping("/settleAccount")
    public String showSettleAccount() {
        return "settleAccount";
    }

    @RequestMapping("/api/delete")
    @ResponseBody
    public ResponseEntity<Result> deleteProduct(Integer id) {
        Content content = new Content();
        content.setId(id);
        Result result = new Result(HttpStatus.OK.value(), "删除成功！", true);
        try {
            Integer i = contentService.delete(content);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("删除失败");
            result.setResult(false);
        }
        return new ResponseEntity<Result>(result, HttpStatus.OK);

    }


    @RequestMapping(value = "/api/upload", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, ModelMap modelMap) {

        if (!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String contextPath = request.getServletContext().getRealPath("/")+"image" ;
            System.out.println(contextPath);
            File file1 = new File(contextPath, fileName);
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", "/image/"+fileName);
        } else {
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", null);
        }

        return modelMap;
    }

    private ProductDTO setProductDTOData(Content c, HttpSession session) {
        ProductDTO p = new ProductDTO();
        p.setId(c.getId());
        p.setTitle(c.getTitle());
        p.setImage(c.getImage());
        p.setPrice(c.getPrice());

        p.setSummary(c.getSummary());
        p.setDetail(c.getDetail());

        Person user = (Person) session.getAttribute("user");
        if (user != null) {
            DealRecord dealRecord = new DealRecord();
            dealRecord.setContentId(c.getId());

            if (user.getUserType() == 0) { //买家
                dealRecord.setPersonId(user.getId());
            } else {//卖家
                dealRecord.setPersonId(-1);
            }

            List<DealRecord> buyListStart = dealRecordService.selectByItem(dealRecord);
            //售卖个数
            Integer num = dealRecordService.selectNumCountByItem(dealRecord);
            if (buyListStart.size() > 0) {
                DealRecord d = buyListStart.get(buyListStart.size() - 1);
                p.setBuyPrice(d.getPrice());
                p.setBuyNum(d.getNum());
                p.setBuyTime(d.getTime());

                p.setIsBuy(true);
                p.setIsSell(true);
                p.setSellNum(num);
            }
        }
        return p;
    }

}
