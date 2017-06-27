package com.zhangyifa.test.dao.impl;

import com.zhangyifa.test.dao.MyDao;
import com.zhangyifa.test.entity.Person;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;

/**
 * Created by zyf on 2017/6/27.
 */
public class MyDaoImpl extends HibernateDaoSupport implements MyDao {


    @Override
    public void save(Person person) {

        getHibernateTemplate().save(person);
    }

    @Override
    public Person findPerson(Serializable id) {
        return getHibernateTemplate().get(Person.class,id);
    }

}
