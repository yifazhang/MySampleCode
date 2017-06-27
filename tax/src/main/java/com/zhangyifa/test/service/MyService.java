package com.zhangyifa.test.service;

import com.zhangyifa.test.entity.Person;

import java.io.Serializable;

/**
 * Created by zhangyifa on 6/26/17.
 */
public interface MyService {

    //输出
    void say();

    //保存
    public void save(Person person);

    //查找
    public Person findPerson(Serializable id);

}

















