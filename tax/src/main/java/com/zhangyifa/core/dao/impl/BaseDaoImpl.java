package com.zhangyifa.core.dao.impl;

import com.zhangyifa.core.dao.BaseDao;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by zhangyifa on 6/27/17.
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    Class<T> clazz;

    public BaseDaoImpl() {
        //getGenericSuperclass()获得带有泛型的父类
        //Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
        //ParameterizedType参数化类型，即泛型
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();//BaseDaoImpl<T>
        clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(Object entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(Object entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(Serializable id) {
        getHibernateTemplate().delete(findObjectById(id));
    }

    @Override
    public T findObjectById(Serializable id) {
        return getHibernateTemplate().get(clazz,id);
    }

    @Override
    public List findObjects() {
        Query query = currentSession().createQuery("FROM " + clazz.getSimpleName());
        return query.list();
    }
}

/*
public class Person<T> {

}

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Student extends Person<Student> {
    public static void main(String[] args) {
        Student st=new Student();
        Class clazz=st.getClass();
        //getSuperclass()获得该类的父类
        System.out.println(clazz.getSuperclass());
        //getGenericSuperclass()获得带有泛型的父类
        //Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
        Type type=clazz.getGenericSuperclass();
        System.out.println(type);
        //ParameterizedType参数化类型，即泛型
        ParameterizedType p=(ParameterizedType)type;
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Class c=(Class) p.getActualTypeArguments()[0];
        System.out.println(c);
    }
}

打印结果：

class com.test.Person
com.test.Person<com.test.Student>
class com.test.Student
 */