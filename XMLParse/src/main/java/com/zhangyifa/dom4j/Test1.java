package com.zhangyifa.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * Created by zyf on 2017/6/19.
 */
public class Test1 {

    public static void main(String[] args) {
        //1.创建一个xml解析器对象
        SAXReader reader = new SAXReader();
        try {
            //2.读取xml文件，返回Document对象
            Document document = reader.read(new File("src/main/resources/contact.xml"));
            System.out.println(document);

            //3.得到当前节点下的所有子节点
            Iterator<Node> iterator = document.nodeIterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                String name = node.getName();
                System.out.println(name);

                //判断当前节点是否是标签节点
                if (node instanceof Element) {
                    Element element = (Element) node;
                    Iterator<Node> ite = element.nodeIterator();
                    while (ite.hasNext()) {
                        Node node1 = ite.next();
                        String name2 = node1.getName();
                        System.out.println(name2);
                    }
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
