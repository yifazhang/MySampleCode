package com.zhangyifa.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zyf on 2017/6/19.
 */
public class Test6 {
    public static void main(String[] args) throws Exception {
        List<Contact> list = new ArrayList<Contact>();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("src/main/resources/contact.xml"));



        //指定写入格式
//        OutputFormat format = OutputFormat.createCompactFormat();//紧凑的格式，去空格换行
        OutputFormat format = OutputFormat.createPrettyPrint();//漂亮的格式，有空格换行
        //编码设置
        format.setEncoding("utf-8");
        //指定文件流输出的位置
        FileOutputStream out = new FileOutputStream("src/main/resources/new.xml");

        //创建写出对象
        XMLWriter writer = new XMLWriter(out,format);
        //写出对象
        writer.write(doc);
        writer.close();
    }
}
