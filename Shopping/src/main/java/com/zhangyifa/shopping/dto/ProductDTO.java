package com.zhangyifa.shopping.dto;

import java.sql.Timestamp;

/**
 * Created by zyf on 2017/7/25.
 */
public class ProductDTO {

    private Integer id; //产品id
    private String title; //标题
    private String image;//图片
    private Double price;//价格
    private boolean isBuy;//当前用户是否已经购买
    private boolean isSell;//是否已经卖出
    private String summary;//摘要
    private String detail;//全文
    private Double buyPrice;//购买时的价格
    private Integer buyNum;//购买数量
    private Timestamp buyTime;//购买时间13位时间戳
    private Integer sellNum;//销售数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(boolean isBuy) {
        this.isBuy = isBuy;
    }

    public boolean getIsSell() {
        return isSell;
    }

    public void setIsSell(boolean isSell) {
        this.isSell = isSell;
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

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Timestamp getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", isBuy=" + isBuy +
                ", isSell=" + isSell +
                ", summary='" + summary + '\'' +
                ", detail='" + detail + '\'' +
                ", buyPrice=" + buyPrice +
                ", buyNum=" + buyNum +
                ", buyTime=" + buyTime +
                ", sellNum=" + sellNum +
                '}';
    }
}
