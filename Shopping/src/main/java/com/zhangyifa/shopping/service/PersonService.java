package com.zhangyifa.shopping.service;

import com.zhangyifa.shopping.entity.Page;
import com.zhangyifa.shopping.entity.Person;

/**
 * Created by zyf on 2017/7/18.
 */
public interface PersonService extends BaseService<Person> {
    public Person login(Person person);
}
