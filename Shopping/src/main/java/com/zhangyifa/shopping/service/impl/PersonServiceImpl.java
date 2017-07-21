package com.zhangyifa.shopping.service.impl;

import com.zhangyifa.shopping.dao.PersonDao;
import com.zhangyifa.shopping.entity.Page;
import com.zhangyifa.shopping.entity.Person;
import com.zhangyifa.shopping.service.BaseService;
import com.zhangyifa.shopping.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyf on 2017/7/18.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Person login(Person person) {
        return personDao.login(person);
    }

    @Override
    public Integer insert(Person entity) throws Exception {
        return null;
    }

    @Override
    public Integer update(Person entity) throws Exception {
        return null;
    }

    @Override
    public Integer delete(Person entity) throws Exception {
        return null;
    }

    @Override
    public Integer deleteList(String[] pks) throws Exception {
        return null;
    }

    @Override
    public List<Person> selectAll() {
        return null;
    }

    @Override
    public Person selectById(Serializable id) {
        return personDao.selectById(id);
    }

    @Override
    public Person select(Person entity) {
        return null;
    }

    @Override
    public Page<Person> selectPage(Page<Person> page) {
        return null;
    }

    @Override
    public Page<Person> selectPageUseDyc(Page<Person> page) {
        return null;
    }
}
