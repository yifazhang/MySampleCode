package com.zhangyifa.nsfw.role.dao;

import com.zhangyifa.core.dao.BaseDao;
import com.zhangyifa.nsfw.role.entity.Role;


/**
 * Created by zyf on 2017/7/6.
 */
public interface RoleDao extends BaseDao<Role> {

    //删除该角色对于的所有权限
    public void deleteRolePrivilegeByRoleId(String roleId);
}
