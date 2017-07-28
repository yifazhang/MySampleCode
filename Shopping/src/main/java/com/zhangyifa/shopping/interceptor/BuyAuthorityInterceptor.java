package com.zhangyifa.shopping.interceptor;

import com.zhangyifa.shopping.entity.Person;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zyf on 2017/7/27.
 */
public class BuyAuthorityInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("SellAuthorityInterceptor preHandle--------------");
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");

        if(person != null) {//判断用户是否登录
            if (person.getUserType() == 1) {//卖家
                //则重定向到没有权限页面
                response.sendRedirect("authority");
                return false;
            }
            return true;
        } else {
            //则重定向到登录页面
            response.sendRedirect("login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
