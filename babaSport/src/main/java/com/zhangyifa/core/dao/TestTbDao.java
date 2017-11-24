package com.zhangyifa.core.dao;

import com.zhangyifa.core.bean.TestTb;

import java.util.List;

/**
 * Created by zyf on 2017/11/24.
 */
public interface TestTbDao {
    public void addTestTb(TestTb testTb);

    public List<TestTb> listTb();
}
