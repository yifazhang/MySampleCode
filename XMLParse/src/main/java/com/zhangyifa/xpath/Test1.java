package com.zhangyifa.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by zyf on 2017/6/19.
 */
public class Test1 {

    public static void main(String[] args) throws Exception {

        //删除id值为3的学生标签
        Document doc = new SAXReader().read(new File("src/main/resources/contact.xml"));
        Element contElem = (Element) doc.selectSingleNode("//contact[@id='002']");
        contElem.detach();

        //指定写入格式
//        OutputFormat format = OutputFormat.createCompactFormat();//紧凑的格式，去空格换行
        OutputFormat format = OutputFormat.createPrettyPrint();//漂亮的格式，有空格换行
        //编码设置
        format.setEncoding("utf-8");
        //指定文件流输出的位置
        FileOutputStream out = new FileOutputStream("src/main/resources/new2.xml");

        //创建写出对象
        XMLWriter writer = new XMLWriter(out,format);
        //写出对象
        writer.write(doc);
        writer.close();
    }
}
