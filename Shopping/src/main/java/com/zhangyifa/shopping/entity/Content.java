package com.zhangyifa.shopping.entity;

import java.io.Serializable;

/**
 * Created by zyf on 2017/7/18.
 */
public class Content implements Serializable {


   private int id;
   private long price;
   private String title;
   private String image;
   private String icon;
   private String summary;
   private String detail;
   private String pic;

   private boolean buy;
   private boolean sell;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", icon='" + icon + '\'' +
                ", summary='" + summary + '\'' +
                ", detail='" + detail + '\'' +
                ", pic='" + pic + '\'' +
                ", buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
