package com.zhangyifa.shopping.entity;

import java.util.Date;

/**
 * Created by zyf on 2017/7/18.
 */
public class DealRecord {

    private int id;
    private int contentId;
    private int personId;
    private int price;
    private Date time;

    public DealRecord() {
    }

    public DealRecord(int contentId, int personId, int price, Date time) {
        this.contentId = contentId;
        this.personId = personId;
        this.price = price;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DealRecordDao{" +
                "id=" + id +
                ", contentId=" + contentId +
                ", personId=" + personId +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}
