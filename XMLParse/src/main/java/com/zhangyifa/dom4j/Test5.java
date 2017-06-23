package com.zhangyifa.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zyf on 2017/6/19.
 */
public class Test5 {
    public static void main(String[] args) throws DocumentException {
        List<Contact> list = new ArrayList<Contact>();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("src/main/resources/contact.xml"));

        Iterator<Element> it = doc.getRootElement().elementIterator();
        while (it.hasNext()) {
            Element elem = it.next();
            Contact contact = new Contact();
            contact.setId(elem.attributeValue("id"));
            contact.setName(elem.elementText("name"));
            contact.setAge(elem.elementText("age"));
            contact.setPhone(elem.elementText("phone"));
            contact.setEmail(elem.elementText("email"));
            contact.setQq(elem.elementText("qq"));
            list.add(contact);
        }

        System.out.println(list);
    }
}
