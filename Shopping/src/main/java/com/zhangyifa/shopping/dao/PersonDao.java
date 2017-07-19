package com.zhangyifa.shopping.dao;

import com.zhangyifa.shopping.entity.Person;

/**
 * Created by zyf on 2017/7/18.
 */
public interface PersonDao extends BaseDao<Person>{
    public Person login(Person person);
}
