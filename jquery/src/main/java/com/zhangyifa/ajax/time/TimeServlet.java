package com.zhangyifa.ajax.time;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zyf on 2017/6/20.
 */
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowStr = sdf.format(new Date());
        System.out.println(nowStr);
        req.setAttribute("nowStr",nowStr);
        System.out.println(req.getAttribute("nowStr"));
        req.getRequestDispatcher("/ajax/index.jsp").forward(req,resp);
    }
}
