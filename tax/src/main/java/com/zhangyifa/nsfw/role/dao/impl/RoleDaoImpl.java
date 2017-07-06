package com.zhangyifa.nsfw.role.dao.impl;

import com.zhangyifa.core.dao.impl.BaseDaoImpl;
import com.zhangyifa.nsfw.role.dao.RoleDao;
import com.zhangyifa.nsfw.role.entity.Role;
import org.hibernate.query.Query;

/**
 * Created by zyf on 2017/7/6.
 */
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    @Override
    public void deleteRolePrivilegeByRoleId(String roleId) {
        Query query = currentSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId = ?");
        query.setParameter(0,roleId);
        query.executeUpdate();
    }
}
