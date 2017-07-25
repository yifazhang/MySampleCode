package com.zhangyifa.shopping.web;

import com.zhangyifa.shopping.dto.ProductDTO;
import com.zhangyifa.shopping.entity.Content;
import com.zhangyifa.shopping.entity.DealRecord;
import com.zhangyifa.shopping.entity.Person;
import com.zhangyifa.shopping.entity.Result;
import com.zhangyifa.shopping.service.ContentService;
import com.zhangyifa.shopping.service.DealRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyf on 2017/7/25.
 */
@Controller
public class TraditionController {

    @Autowired
    ContentService contentService;

    @Autowired
    DealRecordService dealRecordService;

    @RequestMapping(value = "/api/buy", method = RequestMethod.POST)
    public ResponseEntity<Result> tradition(@RequestBody List<DealRecord> records, HttpSession session) {
        System.out.println(records.toString());
        Person p = (Person)session.getAttribute("user");
        Result result = new Result(HttpStatus.OK.value(),"购买成功！",true);

        try {
            for (DealRecord record : records) {
                record.setPersonId(p.getId());
                Content product = contentService.selectById(record.getContentId());
                System.out.println(product.toString());
                record.setPrice(product.getPrice());
                System.out.println("end \n " + record.toString());
                dealRecordService.insert(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(HttpStatus.BAD_REQUEST.value());
            result.setMessage("购买失败");
            result.setResult(false);
        }

        return new ResponseEntity<Result>(result, HttpStatus.OK);
    }

    @RequestMapping({"/account"})
    public String index(Model model,HttpSession session) {

        Person user = (Person)session.getAttribute("user");
        if (user == null) return "redirect:login";

        List<DealRecord> buyListStart = dealRecordService.selectByUserId(user.getId());
        List<ProductDTO> buyList = new ArrayList<>();
        for (DealRecord d: buyListStart ) {
            ProductDTO p = new ProductDTO();
            p.setId(d.getContentId());
            Content c = contentService.selectById(d.getContentId());
            p.setTitle(c.getTitle());
            p.setImage(c.getImage());
            p.setPrice(c.getPrice());

            p.setSummary(c.getSummary());
            p.setDetail(c.getDetail());
            p.setBuyPrice(d.getPrice());
            p.setBuyNum(d.getNum());
            p.setBuyTime(d.getTime());
            buyList.add(p);
        }
        model.addAttribute("buyList",buyList);
        return "account";
    }
}
