package com.zhangyifa.core.service.impl;

import com.zhangyifa.core.bean.TestTb;
import com.zhangyifa.core.dao.TestTbDao;
import com.zhangyifa.core.service.TestTbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zyf on 2017/11/24.
 */
@Service
@Transactional
public class TestTbServiceImpl implements TestTbService{

    @Resource
    private TestTbDao testTbDao;

    public void addTestTb(TestTb testTb) {
        testTbDao.addTestTb(testTb);
    }

    @Transactional(readOnly = true)
    public List<TestTb> listTb() {
        return testTbDao.listTb();
    }
}
