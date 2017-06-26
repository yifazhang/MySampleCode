package com.zhangyifa.test.service;

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

    }


}