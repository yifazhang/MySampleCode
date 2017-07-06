package com.zhangyifa.nsfw.role.service.impl;

import com.zhangyifa.nsfw.role.dao.RoleDao;
import com.zhangyifa.nsfw.role.entity.Role;
import com.zhangyifa.nsfw.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zyf on 2017/7/6.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void update(Role role) {
        //1、删除该角色对于的所有权限
        roleDao.deleteRolePrivilegeByRoleId(role.getRoleId());
        //2、更新角色及其权限
        roleDao.update(role);
    }

    @Override
    public void delete(Serializable id) {
        roleDao.delete(id);
    }

    @Override
    public Role findObjectById(Serializable id) {
        return roleDao.findObjectById(id);
    }

    @Override
    public List<Role> findObjects() {
        return roleDao.findObjects();
    }
}
