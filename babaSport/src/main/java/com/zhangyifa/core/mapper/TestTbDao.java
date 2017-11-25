package com.zhangyifa.core.mapper;

import com.zhangyifa.core.pojo.TestTb;

import java.util.List;

/**
 * Created by zhangyifa on 11/25/17.
 */
public interface TestTbDao {

    public void addTestTb(TestTb testTb);
    public List<TestTb> listTb() ;
}
