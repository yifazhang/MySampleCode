package com.zhangyifa.nsfw.user.dao;

import com.zhangyifa.core.dao.BaseDao;
import com.zhangyifa.nsfw.user.entity.User;

import java.util.List;

/**
 * Created by zhangyifa on 6/27/17.
 */
public interface UserDao extends BaseDao<User> {

    List<User> findUserByAccountAndId(String id, String account);
}
