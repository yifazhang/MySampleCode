package com.zhangyifa.ajax.user;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("username=" + username);
        String tip = "<font color='green'>可以注册</font>";
        if("杰克".equals(username)){
            tip = "<font color='red'>该用户已存在</font>";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write(tip);
        pw.flush();
        pw.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println("username="+username);

        String tip = "image/MsgSent.gif";
        if("杰克".equals(username)){
            tip = "image/MsgError.gif";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write(tip);
        pw.flush();
        pw.close();

    }
}
