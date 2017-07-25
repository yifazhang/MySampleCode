package com.zhangyifa.shopping.service;

import com.zhangyifa.shopping.entity.DealRecord;
import com.zhangyifa.shopping.entity.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyf on 2017/7/18.
 */
public interface DealRecordService extends BaseService<DealRecord> {

    //查询该用户所购买记录
    public List<DealRecord> selectByUserId(Serializable id);
}
