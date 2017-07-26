package com.zhangyifa.shopping.service;

import com.zhangyifa.shopping.entity.DealRecord;

import java.util.List;

/**
 * Created by zyf on 2017/7/18.
 */
public interface DealRecordService extends BaseService<DealRecord> {

    //查询该用户所购买记录
    public List<DealRecord> selectByItem(DealRecord dealRecord);

    //查询购买个数
    public Integer selectNumCountByItem(DealRecord dealRecord);

}
