package com.zhangyifa.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zyf on 2017/6/19.
 */
public class Test4 {

    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("src/main/resources/contact.xml"));

        Element rootElem = doc.getRootElement();

        StringBuffer sb = new StringBuffer();

        getChildNodes(rootElem,sb);
        System.out.println(sb);
    }

    public static void getChildNodes(Element elem,StringBuffer sb) {
//        System.out.println(elem.getName());

        sb.append("<"+elem.getName());

        //得到标签的属性列表
        List<Attribute> attrs = elem.attributes();
        for(Attribute attr : attrs) {
//            System.out.println(attr.getName() + "=" + attr.getValue());
            sb.append(" "+attr.getName()+"=\"" + attr.getValue()+"\"");
        }
        sb.append(">");


//        String content = elem.getText();
//        System.out.println(content);

        Iterator<Node> it = elem.nodeIterator();
          while (it.hasNext()) {
              Node node = it.next();

              //标签
              if (node instanceof Element) {
                 Element el = (Element)node;
                 getChildNodes(el,sb);
              }

              //文本
              if (node instanceof Text) {
                   Text text = (Text)node;
                  System.out.println(text.getText());
                   sb.append(text.getText());
              }
          }

        //结束标签
        sb.append("</"+elem.getName()+">");
    }
}
