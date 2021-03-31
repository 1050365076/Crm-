package com.xy.work.crm.dao;


import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission,Integer> {

    int countPermissionByRoleId(Integer roleId);

    int deletePermissionByRoleId(Integer roleId);

    List<Integer> queryRoleHasAllMids(Integer roleId);
}
