package com.zhangyifa.shopping.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyf on 2017/7/18.
 */
public interface BaseDao<T> {

    //添加单个对象
    public Integer insert(T entity);

    //修改单个对象
    public Integer update(T entity);

    //删除单个对象
    public Integer delete(T entity);

    //查询单个对象
    public T selectById(Serializable id);

    //查询单个对象
    public T select(T entity);

    //查询所有
    public List<T> selectAll();

}
