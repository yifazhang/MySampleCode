package com.zhangyifa.nsfw.user.dao.impl;

import com.zhangyifa.core.dao.impl.BaseDaoImpl;
import com.zhangyifa.nsfw.user.dao.UserDao;
import com.zhangyifa.nsfw.user.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by zhangyifa on 6/27/17.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public List<User> findUserByAccountAndId(String id, String account) {
        String hql = "FROM User WHERE account = ?";
        if (StringUtils.isNotBlank(id)) {
            hql += " AND id = ?";
        }
        Query query = currentSession().createQuery(hql);
        query.setParameter(0, account);
        if (StringUtils.isNotBlank(id)) {
            query.setParameter(1, id);
        }
        return query.list();
    }
}
