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
public class Test2 {

    public static void main(String[] args) {
        //1.创建一个xml解析器对象
        SAXReader reader = new SAXReader();
        try {
            //2.读取xml文件，返回Document对象
            Document document = reader.read(new File("src/main/resources/contact.xml"));
            System.out.println(document);

            //3.得到根标签
            Element rootElement = document.getRootElement();
            getChildNodes(rootElement);


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void getChildNodes(Element element) {
        System.out.println(element.getName());

        //得到子节点
        Iterator<Node> it = element.nodeIterator();
        while (it.hasNext()) {
            Node node = it.next();

            if (node instanceof Element) {
                Element el = (Element)node;
                //递归
                getChildNodes(el);
            }
        }

    }
}
