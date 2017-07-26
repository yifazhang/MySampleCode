package com.zhangyifa.shopping.service.impl;

import com.zhangyifa.shopping.dao.DealRecordDao;
import com.zhangyifa.shopping.entity.DealRecord;
import com.zhangyifa.shopping.service.DealRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyf on 2017/7/18.
 */
@Service
public class DealRecordServiceImpl implements DealRecordService {

    @Autowired
    private DealRecordDao dealRecordDao;

    @Override
    public Integer insert(DealRecord entity) throws Exception {
        return dealRecordDao.insert(entity);
    }

    @Override
    public Integer update(DealRecord entity) throws Exception {
        return dealRecordDao.update(entity);
    }

    @Override
    public Integer delete(DealRecord entity) throws Exception {
        return dealRecordDao.delete(entity);
    }

    @Override
    public List<DealRecord> selectAll() {
        return null;
    }

    @Override
    public DealRecord selectById(Serializable id) {
        return dealRecordDao.selectById(id);
    }

    @Override
    public DealRecord select(DealRecord entity) {
        return dealRecordDao.select(entity);
    }

    @Override
    public List<DealRecord> selectByItem(DealRecord dealRecord) {
        return dealRecordDao.selectByItem(dealRecord);
    }

    @Override
    public Integer selectNumCountByItem(DealRecord dealRecord) {
        return dealRecordDao.selectNumCountByItem(dealRecord);
    }
}
