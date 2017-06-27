package com.zhangyifa.test.dao;

import com.zhangyifa.test.entity.Person;

import java.io.Serializable;

/**
 * Created by zyf on 2017/6/27.
 */
public interface MyDao {

    //保存
    public void save(Person person);

    //查找
    public Person findPerson(Serializable id);
}
