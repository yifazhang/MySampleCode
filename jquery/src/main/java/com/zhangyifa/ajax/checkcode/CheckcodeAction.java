package com.zhangyifa.ajax.checkcode;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by zyf on 2017/6/21.
 */
public class CheckcodeAction extends ActionSupport{

    private String checkcode;

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    /**
     * 验证码检查
     * @return
     * @throws Exception
     */
    public String check() throws Exception {
        String tip = "../images/MsgError.gif";
        //从服务器获取session中的验证码
        String checkcodeServer = (String) ActionContext.getContext().getSession().get("CHECKNUM");
        //比较
        if (checkcode.equals(checkcodeServer)){
            tip = "../images/MsgSent.gif";
        }
        //以IO流的方式将tip变量的值输出到AJAX异步对象中
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write(tip);
        pw.flush();
        pw.close();
        //此方式不是最好
        return null;
    }












}
