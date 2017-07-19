package com.zhangyifa.shopping.entity;

import java.io.Serializable;

/**
 * Created by zyf on 2017/7/18.
 */
public class Content implements Serializable {


   private int id;
   private long price;
   private String title;
   private String icon;
   private String abstractContent;
   private String text;

   public Content() {
   }

    public Content(long price, String title, String icon, String abstractContent, String text) {
        this.price = price;
        this.title = title;
        this.icon = icon;
        this.abstractContent = abstractContent;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", abstractContent='" + abstractContent + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
