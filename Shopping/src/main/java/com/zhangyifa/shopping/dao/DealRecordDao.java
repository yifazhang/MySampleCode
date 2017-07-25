package com.zhangyifa.shopping.dao;

import com.zhangyifa.shopping.entity.DealRecord;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyf on 2017/7/18.
 */
public interface DealRecordDao extends BaseDao<DealRecord>{

    //查询该用户所购买记录
    public List<DealRecord> selectByUserId(Serializable id);
}
