package com.zhangyifa.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zyf on 2017/6/19.
 */
public class Test3 {

    public static void main(String[] args) {
        //1.创建一个xml解析器对象
        SAXReader reader = new SAXReader();
        try {
            //2.读取xml文件，返回Document对象
            Document document = reader.read(new File("src/main/resources/contact.xml"));
            System.out.println(document);

            System.out.println("------得到根标签--------");
            //3.得到根标签
            Element rootElement = document.getRootElement();
            String name = rootElement.getName();
            System.out.println(name);

            System.out.println("------得到所有标签--------");
            getChildNodes(rootElement);

            System.out.println("------得到当前标签(contact)下指定名称的第一个子标签--------");
            //得到当前标签下指定名称的第一个子标签
            Element contactElem = rootElement.element("contact");
            System.out.println(contactElem.getName());

            System.out.println("------得到当前标签(contact)下指定名称的所有子标签--------");
            //得到当前标签下指定名称的所有子标签
            Iterator<Element> it = rootElement.elementIterator("contact");
            while (it.hasNext()) {
                Element elem = it.next();
                System.out.println(elem.getName());
            }

            System.out.println("------得到当前标签(根标签)下所有子标签--------");
            //得到当前标签下所有子标签
            List<Element> list = rootElement.elements();
            for(Element element: list) {
                System.out.println(element.getName());
            }

            System.out.println("------取更深层次的标读签 根-contact-name --------");
            //取更深层次的标读签
            Element element = document.getRootElement().element("contact").element("name");
            System.out.println(element.getName());

            //获得属性
            System.out.println("--------根-contact 的属性");
            Element conElem = document.getRootElement().element("contact");
            String idValue = conElem.attributeValue("id");
            System.out.println(idValue);

            System.out.println("--------根-contact 的属性对象");
            Attribute attribute = conElem.attribute("id");
            System.out.println(attribute.getName() + " - " + attribute.getValue());

            System.out.println("--------根-contact 的所有属性对象");
            List<Attribute> attributeList = conElem.attributes();
            for (Attribute attribute1: attributeList) {
                System.out.println(attribute1.getName() + " - " + attribute1.getValue());
            }

            System.out.println("--------根-contact-name 得到文本-------");
            String text = element.getText();
            System.out.println(text);


            System.out.println("--------根-contact-name 得到文本-------");
            String text2 = document.getRootElement().element("contact").elementText("name");
            System.out.println(text2);

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
