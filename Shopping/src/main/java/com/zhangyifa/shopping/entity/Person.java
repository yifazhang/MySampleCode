package com.zhangyifa.shopping.entity;

/**
 * Created by zyf on 2017/7/18.
 */
public class Person {

    private int id;
    private String userName;
    private String passWord;
    private String nickName;
    private int userType;

    public Person() {
    }

    public Person(String userName, String passWord, String nickName, int userType) {
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "PersonController{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userType=" + userType +
                '}';
    }
}
