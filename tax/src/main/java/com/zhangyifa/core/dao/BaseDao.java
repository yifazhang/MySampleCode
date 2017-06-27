package com.zhangyifa.core.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangyifa on 6/27/17.
 */
public interface BaseDao<T> {

    /**
     * 新增
     * @param entity
     */
    public void save(T entity);

    /**
     * 更新
     * @param entity
     */
    public void update(T entity);

    /**
     * 根据id删除
     * @param id
     */
    public void delete(Serializable id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public T findObjectById(Serializable id);

    /**
     * 查找列表
     * @return
     */
    public List<T> findObjects();

}
