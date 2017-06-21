package com.zhangyifa.ajax.city;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zyf on 2017/6/21.
 */
@WebServlet("/ProvinceCityServlet")
public class ProvinceCityServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        这两句话等效
//        request.setCharacterEncoding("UTF-8");
//        String s=new String(request.getParameter("province").getBytes("ISO-8859-1"),"UTF-8") ;

        request.setCharacterEncoding("UTF-8");
        String province = request.getParameter("province");

        System.out.println("province="+province);
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        pw.write("<?xml version='1.0' encoding='UTF-8'?>");
        pw.write("<root>");

        if ("广东".equals(province)) {
            pw.write("<city>广州</city>");
            pw.write("<city>深圳</city>");
            pw.write("<city>中山</city>");
        } else if ("湖南".equals(province)) {
            pw.write("<city>长沙</city>");
            pw.write("<city>株洲</city>");
            pw.write("<city>衡阳</city>");
            pw.write("<city>湘潭</city>");
        }
        pw.write("</root>");
        pw.flush();
        pw.close();
    }
}
