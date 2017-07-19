package com.zhangyifa.shopping.service.impl;

import com.zhangyifa.shopping.dao.ContentDao;
import com.zhangyifa.shopping.entity.Content;
import com.zhangyifa.shopping.entity.Page;
import com.zhangyifa.shopping.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zyf on 2017/7/18.
 */
@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentDao contentDao;

    @Override
    public int insert(Content entity) throws Exception {
        return contentDao.insert(entity);
    }

    @Override
    public int update(Content entity) throws Exception {
        return contentDao.update(entity);
    }

    @Override
    public int delete(Content entity) throws Exception {
        return contentDao.delete(entity);
    }

    @Override
    public int deleteList(String[] pks) throws Exception {
        return contentDao.deleteList(pks);
    }

    @Override
    public Content select(Content entity) {
        return contentDao.select(entity);
    }

    @Override
    public Page<Content> selectPage(Page<Content> page) {
        page.setList(contentDao.selectPageList(page));
        page.setTotalRecord(contentDao.selectPageCount(page));
        return page;
    }

    @Override
    public Page<Content> selectPageUseDyc(Page<Content> page) {
        page.setList(contentDao.selectPageListUseDyc(page));
        page.setTotalRecord(contentDao.selectPageCountUseDyc(page));
        return page;
    }
}
