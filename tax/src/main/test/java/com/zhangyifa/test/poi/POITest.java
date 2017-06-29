package com.zhangyifa.test.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * Created by zyf on 2017/6/29.
 */
public class POITest {

    @Test
    public void testWrite03Excel() throws Exception {

        //1.创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.创建工作表
        HSSFSheet sheet = workbook.createSheet("hello world");//指定工作表名
        //3.创建行
        HSSFRow row = sheet.createRow(2);
        //4.创建单元格
        HSSFCell cell = row.createCell(1);
        cell.setCellValue("Hello World");

        //输出到硬盘
        String path = new File("").getAbsolutePath() + "/file/test.xls";
        FileOutputStream outputStream = new FileOutputStream(path);
        //把Excel输出
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    @Test
    public void testRead03Excel() throws Exception {
        String path = new File("").getAbsolutePath() + "/file/test.xls";
        FileInputStream inputStream = new FileInputStream(path);
        //1.读取工作簿
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        //2.读取工作表
        HSSFSheet sheet = workbook.getSheetAt(0);
        //3.读取行
        HSSFRow row = sheet.getRow(2);
        //4.读取单元格
        HSSFCell cell = row.getCell(1);

        System.out.println("读取第3行第2列的内容:"+cell.getStringCellValue());

        workbook.close();
        inputStream.close();
    }

    @Test
    public void testWrite07Excel() throws Exception {

        //1.创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //2.创建工作表
        XSSFSheet sheet = workbook.createSheet("hello world");//指定工作表名
        //3.创建行
        XSSFRow row = sheet.createRow(2);
        //4.创建单元格
        XSSFCell cell = row.createCell(1);
        cell.setCellValue("Hello World");

        //输出到硬盘
        String path = new File("").getAbsolutePath() + "/file/test.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        //把Excel输出
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    @Test
    public void testRead07Excel() throws Exception {
        String path = new File("").getAbsolutePath() + "/file/test.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        //1.读取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        //2.读取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //3.读取行
        XSSFRow row = sheet.getRow(2);
        //4.读取单元格
        XSSFCell cell = row.getCell(1);

        System.out.println("读取第3行第2列的内容:"+cell.getStringCellValue());

        workbook.close();
        inputStream.close();
    }

    @Test
    public void testRead03And07Excel() throws Exception {
        String path = new File("").getAbsolutePath() + "/file/test.xlsx";
        FileInputStream inputStream = new FileInputStream(path);

       if (!path.matches("^.+\\.((?i)(xls)|(xlsx))$")) {
            return;
        }

        boolean is03Excel;
        if (path.matches("^.+\\.((?i)(xls))$")) {
            is03Excel = true;
        } else {
            is03Excel = false;
        }

        //1.读取工作簿
        Workbook workbook = is03Excel ? new HSSFWorkbook(inputStream) : new XSSFWorkbook(inputStream);
        //2.读取工作表
        Sheet sheet = workbook.getSheetAt(0);
        //3.读取行
        Row row = sheet.getRow(2);
        //4.读取单元格
        Cell cell = row.getCell(1);

        System.out.println("读取第3行第2列的内容:"+cell.getStringCellValue());

        workbook.close();
        inputStream.close();
    }



    @Test
    public void testExcelStyle() throws Exception {
        //1、创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //1.1、创建合并单元格对象;合并第3行的第3列到第5列
        CellRangeAddress cellRangeAddress = new CellRangeAddress(2,2,1,4);
        //起始行号，结束行号，起始列号，结束列号
        //1.2、创建单元格样式
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中

        //1.3、创建字体
        Font font = workbook.createFont();
        font.setBold(true);//加粗字体
        font.setFontHeightInPoints((short) 16);//设置字体大小
        //加载字体
        style.setFont(font);

        //单元格背景
        //设置背景填充模式
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置填充背景色
//        style.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
        //设置填充前景色
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());

        //2.创建工作表
        Sheet sheet = workbook.createSheet("hello world");//指定工作表名
        //2.1、加载合并单元格对象
        sheet.addMergedRegion(cellRangeAddress);
        // 3.创建行
        Row row = sheet.createRow(2);
        //4.创建单元格
        Cell cell = row.createCell(1);
        //加载样式
        cell.setCellStyle(style);
        cell.setCellValue("Hello World");

        //输出到硬盘
        String path = new File("").getAbsolutePath() + "/file/test.xls";
        FileOutputStream outputStream = new FileOutputStream(path);
        //把Excel输出
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}


















