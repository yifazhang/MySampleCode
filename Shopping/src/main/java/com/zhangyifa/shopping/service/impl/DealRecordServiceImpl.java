package com.zhangyifa.shopping.service.impl;

import com.zhangyifa.shopping.dao.DealRecordDao;
import com.zhangyifa.shopping.entity.DealRecord;
import com.zhangyifa.shopping.entity.Page;
import com.zhangyifa.shopping.service.DealRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zyf on 2017/7/18.
 */
@Service
public class DealRecordServiceImpl implements DealRecordService {

    @Autowired
    private DealRecordDao dealRecordDao;

    @Override
    public int insert(DealRecord entity) throws Exception {
        return dealRecordDao.insert(entity);
    }

    @Override
    public int update(DealRecord entity) throws Exception {
        return dealRecordDao.update(entity);
    }

    @Override
    public int delete(DealRecord entity) throws Exception {
        return dealRecordDao.delete(entity);
    }

    @Override
    public int deleteList(String[] pks) throws Exception {
        return dealRecordDao.deleteList(pks);
    }

    @Override
    public DealRecord select(DealRecord entity) {
        return dealRecordDao.select(entity);
    }

    @Override
    public Page<DealRecord> selectPage(Page<DealRecord> page) {
        page.setList(dealRecordDao.selectPageList(page));
        page.setTotalRecord(dealRecordDao.selectPageCount(page));
        return page;
    }

    @Override
    public Page<DealRecord> selectPageUseDyc(Page<DealRecord> page) {
        page.setList(dealRecordDao.selectPageListUseDyc(page));
        page.setTotalRecord(dealRecordDao.selectPageCountUseDyc(page));
        return page;
    }
}
