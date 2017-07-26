package com.zhangyifa.shopping.web;

import com.zhangyifa.shopping.entity.Person;
import com.zhangyifa.shopping.entity.Result;
import com.zhangyifa.shopping.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zyf on 2017/7/18.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
       session.removeAttribute("user");
       return "login";
    }

    @RequestMapping("/api/login")
    @ResponseBody
    public ResponseEntity<Result> apilogin(Person person, HttpServletRequest request, HttpSession session) {
        Person loginPerson = personService.login(person);
        if (loginPerson != null) {
            session.setAttribute("user",loginPerson);
            Result result = new Result(HttpStatus.OK.value(),"登录成功！",true);
            return new ResponseEntity<Result>(result, HttpStatus.OK);

        } else {
            Result result = new Result(HttpStatus.BAD_REQUEST.value(),"用户名或密码错误！",false);
            return new ResponseEntity<Result>(result, HttpStatus.OK);

        }
    }

}
