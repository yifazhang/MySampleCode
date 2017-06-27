package com.zhangyifa.test.service;

import com.zhangyifa.test.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by zhangyifa on 6/26/17.
 */
public class MyServiceTest {

    ClassPathXmlApplicationContext ctx;

    @Before
    public void loadCtx() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
     }

    @Test
    public void testSay() throws Exception {
        MyService myService = ctx.getBean("myService",MyService.class);
        myService.say();
    }

    @Test
    public void testHibernate() {
        SessionFactory sf = ctx.getBean("sessionFactory",SessionFactory.class);

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        //保存人员
        session.save(new Person("李四3"));
        transaction.commit();
        session.close();

    }


    @Test
    public void testServiceAndDao() {
        MyService myService = ctx.getBean("myService",MyService.class);
        Person p = new Person("张三3");
        myService.save(p);
        System.out.println(p.getId() + "\n" + p.getName());

        System.out.println(myService.findPerson(p.getId()));

    }

    @Test
    public void testTransationReadOnly() { //只读事务，如果在事务中出现更新操作则回滚
        MyService myService = ctx.getBean("myService",MyService.class);
        System.out.println(myService.findPerson("402881965ce84787015ce8478d000000").getName());
    }

    @Test
    public void testTransationRollback() { //回滚事务，如果在操作出现又任意异常回滚先前的操作
        MyService myService = ctx.getBean("myService",MyService.class);
        Person p = new Person("张三88");
        myService.save(p);
    }


}












