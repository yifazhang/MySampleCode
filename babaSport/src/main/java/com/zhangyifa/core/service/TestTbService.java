package com.zhangyifa.core.service;

import com.zhangyifa.core.pojo.TestTb;

import java.util.List;

/**
 * Created by zyf on 2017/11/24.
 */
public interface TestTbService {
    public void addTestTb(TestTb testTb);

    public List<TestTb> listTb();
}
