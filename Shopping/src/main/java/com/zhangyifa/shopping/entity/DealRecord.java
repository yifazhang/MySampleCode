package com.zhangyifa.shopping.entity;


import java.sql.Timestamp;

/**
 * Created by zyf on 2017/7/18.
 */
public class DealRecord {

    private int id;
    private int contentId;
    private int num;//数量
    private int personId;
    private double price;
    private Timestamp time;

    public DealRecord() {
    }

    public DealRecord(int contentId, int personId, int price, Timestamp time) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "DealRecord{" +
                "id=" + id +
                ", contentId=" + contentId +
                ", num=" + num +
                ", personId=" + personId +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}
