package com.zhangyifa.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zyf on 2017/6/20.
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        byte[] buf = username.getBytes("ISO8859-1");
        username = new String(buf,"UTF-8");
        System.out.println("username="+username);
        String tip = "<font color='green'>可以注册</font>";
        if ("Tom".equals(username)) {
            tip = "<font color='red'>该用户已存在</font>";
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.write(tip);
        pw.flush();
        pw.close();

    }












}
