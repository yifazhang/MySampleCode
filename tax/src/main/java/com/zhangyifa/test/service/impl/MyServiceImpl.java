package com.zhangyifa.test.service.impl;

import com.zhangyifa.test.dao.MyDao;
import com.zhangyifa.test.entity.Person;
import com.zhangyifa.test.service.MyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by zhangyifa on 6/26/17.
 */
@Service("myService")
public class MyServiceImpl implements MyService {

    @Resource
    MyDao myDao;

    @Override
    public void say() {
        System.out.println("MyServiceImpl say hi.");
    }

    @Override
    public void save(Person person) {
        myDao.save(person);
    }

    @Override
    public Person findPerson(Serializable id) {
//        save(new Person("test"));
        return myDao.findPerson(id);
    }
}

