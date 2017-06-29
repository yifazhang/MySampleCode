package com.zhangyifa.nsfw.user.service.impl;

import com.zhangyifa.nsfw.user.dao.UserDao;
import com.zhangyifa.nsfw.user.entity.User;
import com.zhangyifa.nsfw.user.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangyifa on 6/27/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Serializable id) {
        userDao.delete(id);
    }

    @Override
    public User findObjectById(Serializable id) {
        return userDao.findObjectById(id);
    }

    @Override
    public List<User> findObjects() {
        return userDao.findObjects();
    }

    @Override
    public void exportExcel(List<User> userList, ServletOutputStream outputStream) {
        //1、创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //1.1、创建合并单元格对象
        CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 4);
        //1.2、头标题样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        //1.2.1 创建字体
        HSSFFont font = workbook.createFont();
        font.setBold(true);//加粗
        font.setFontHeightInPoints((short)16);
        //加载字体
        style.setFont(font);
        //1.3、列标题样式

        //2、创建工作表
        //2.1、加载合并单元格对象
        //
        //3、创建行
        //3.1、创建头标题行；并且设置头标题
        //3.2、创建列标题行；并且设置列标题
        //
        //4、操作单元格；将用户列表写入excel
        //
        //5、输出
        //

    }
}
