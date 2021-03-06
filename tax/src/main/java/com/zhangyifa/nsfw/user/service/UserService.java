package com.zhangyifa.nsfw.user.service;

import com.zhangyifa.nsfw.user.entity.User;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangyifa on 6/27/17.
 */
public interface UserService {

    /**
     * 新增
     * @param user
     */
    public void save(User user);

    /**
     * 更新
     * @param user
     */
    public void update(User user);

    /**
     * 根据id删除
     * @param id
     */
    public void delete(Serializable id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public User findObjectById(Serializable id);

    /**
     * 查找列表
     * @return
     */
    public List<User> findObjects();

    /**
     * 导出用户列表
     * @param userList 用户列表
     * @param outputStream 输出流
     */
    public void exportExcel(List<User> userList, ServletOutputStream outputStream);

    /**
     * 导入用户列表
     */
    public void importExcel(File userExcel, String userExcelFileName);

    /**
     * 根据账号和用户id查询用户
     * @param id 用户ID
     * @param account 用户账号
     * @return
     */
    public List<User> findUserByAccountAndId(String id, String account);
}
