package com.zhangyifa;

import com.zhangyifa.common.junit.SpringJunitTest;
import com.zhangyifa.core.bean.TestTb;
import com.zhangyifa.core.service.TestTbService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by zyf on 2017/11/24.
 */
public class TestTestTb extends SpringJunitTest {

    @Autowired
    private TestTbService testTbService;

    @Test
    public void testAdd() {
        TestTb tb = new TestTb();
        tb.setName("good哈");
        tb.setBirthday(new Date());

        testTbService.addTestTb(tb);
    }

    @Test
    public void testList() {
        System.out.println(testTbService.listTb());
    }

}
