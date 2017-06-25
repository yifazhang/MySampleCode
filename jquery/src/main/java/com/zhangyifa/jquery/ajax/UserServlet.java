package com.zhangyifa.jquery.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangyifa on 6/24/17.
 */
@WebServlet("/jqueryAjaxUserServlet")
public class UserServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " "  + password);

        String tip = "../../images/MsgError.gif";
        if ("哈哈".equals(username) && "123".equals(password)) {
            tip = "images/MsgSent.gif";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write(tip);
        pw.flush();
        pw.close();
    }

}
