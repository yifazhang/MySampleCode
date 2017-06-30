package com.zhangyifa.nsfw.user.service.impl;

import com.zhangyifa.core.util.ExcelUtil;
import com.zhangyifa.nsfw.user.dao.UserDao;
import com.zhangyifa.nsfw.user.entity.User;
import com.zhangyifa.nsfw.user.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
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
    public void exportExcel(List<User> userList, ServletOutputStream outputStream)  {
        ExcelUtil.exportExcel(userList, outputStream);
    }

    @Override
    public void importExcel(File userExcel, String userExcelFileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(userExcel);
            boolean is03Excel = userExcelFileName.matches("^.+\\.(?i)(xls)$");

            //1.读取工作薄
            Workbook workbook = is03Excel ? new HSSFWorkbook(fileInputStream): new XSSFWorkbook(fileInputStream);
            //2.读取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //3.读取行
            if (sheet.getPhysicalNumberOfRows() > 2) {
                User user = null;
                for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
                    user = new User();
                    //4.读取单元格
                    Row row = sheet.getRow(i);
                    //用户名
                    Cell nameCell = row.getCell(0);
                    user.setName(nameCell.getStringCellValue());
                    //账户
                    Cell accountCell = row.getCell(1);
                    user.setAccount(accountCell.getStringCellValue());
                    //所属部门
                    Cell deptCell = row.getCell(2);
                    user.setDept(deptCell.getStringCellValue());
                    //性别
                    Cell genderCell = row.getCell(3);
                    user.setGender(genderCell.getStringCellValue().equals("男"));
                    //手机号
                    String moible = "";
                    Cell phoneCell = row.getCell(4);
                    try {
                        moible = phoneCell.getStringCellValue();
                    } catch (Exception e){
                        double dMobile = phoneCell.getNumericCellValue();
                        moible = BigDecimal.valueOf(dMobile).toString();
                    }
                    user.setMobile(moible);
                    //电子邮箱
                    Cell emailCell = row.getCell(5);
                    user.setEmail(emailCell.getStringCellValue());
                    //生日
                    Cell birthdayCell = row.getCell(6);
                    if (birthdayCell.getDateCellValue() != null) {
                        user.setBirthday(birthdayCell.getDateCellValue());
                    }
                    //默认密码
                    user.setPassword("123456");
                    //默认状态有效
                    user.setState(User.USER_STATE_VALID);

                    //5.保存用户
                    save(user);

                }
            }
            workbook.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> findUserByAccountAndId(String id, String account) {
        return userDao.findUserByAccountAndId(id,account);
    }


}
