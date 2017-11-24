package com.zhangyifa.core.service;

import com.zhangyifa.core.bean.TestTb;

import java.util.List;

/**
 * Created by zyf on 2017/11/24.
 */
public interface TestTbService {
    public void addTestTb(TestTb testTb);

    public List<TestTb> listTb();
}
