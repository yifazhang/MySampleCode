package com.zhangyifa.shopping.service.impl;

import com.zhangyifa.shopping.dao.ContentDao;
import com.zhangyifa.shopping.entity.Content;
import com.zhangyifa.shopping.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyf on 2017/7/18.
 */
@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentDao contentDao;

    @Override
    public Integer insert(Content entity) throws Exception {
        return contentDao.insert(entity);
    }

    @Override
    public Integer update(Content entity) throws Exception {
        return contentDao.update(entity);
    }

    @Override
    public Integer delete(Content entity) throws Exception {
        return contentDao.delete(entity);
    }

    @Override
    public List<Content> selectAll() {
        return contentDao.selectAll();
    }

    @Override
    public Content selectById(Serializable id) {
        return contentDao.selectById(id);
    }

    @Override
    public Content select(Content entity) {
        return contentDao.select(entity);
    }

}
