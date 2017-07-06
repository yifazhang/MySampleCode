package com.zhangyifa.nsfw.role.entity;

import java.io.Serializable;

/**
 * Created by zyf on 2017/7/6.
 */
public class RolePrivilege implements Serializable {

    private RolePrivilegeId id;

    public RolePrivilege() {
    }

    public RolePrivilege(RolePrivilegeId id) {
        this.id = id;
    }

    public RolePrivilegeId getId() {
        return id;
    }

    public void setId(RolePrivilegeId id) {
        this.id = id;
    }
}
