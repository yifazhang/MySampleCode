package com.zhangyifa.nsfw.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhangyifa.nsfw.user.entity.User;
import com.zhangyifa.nsfw.user.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zyf on 2017/6/28.
 */
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;
    private List<User> userList;
    private User user;
    private String[] selectedRow;

    private static Logger logger = LogManager.getLogger(UserAction.class);


    public String hello() {

        logger.info("跳转到hello");
        return "hello";
    }

    //列表页面
    public String listUI(){
        userList = userService.findObjects();
        return "listUI";
    }
    //跳转到新增页面
    public String addUI(){
        logger.info("跳转到新增页面");
        return "addUI";
    }
    //保存新增
    public String add(){
        if(user != null){
            userService.save(user);
        }
        return "list";
    }
    //跳转到编辑页面
    public String editUI(){
        if (user != null && user.getId() != null) {
            user = userService.findObjectById(user.getId());
        }
        return "editUI";
    }
    //保存编辑
    public String edit(){
        if(user != null){
            userService.update(user);
        }
        return "list";
    }
    //删除
    public String delete(){
        if(user != null && user.getId() != null){
            userService.delete(user.getId());
        }
        return "list";
    }
    //批量删除
    public String deleteSelected(){
        if(selectedRow != null){
            for(String id: selectedRow){
                userService.delete(id);
            }
        }
        return "list";
    }
    public List<User> getUserList() {
        return userList;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String[] getSelectedRow() {
        return selectedRow;
    }
    public void setSelectedRow(String[] selectedRow) {
        this.selectedRow = selectedRow;
    }
}
