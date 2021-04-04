package com.xy.work.crm.dao;


import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission,Integer> {

    int countPermissionByRoleId(Integer roleId);

    int deletePermissionByRoleId(Integer roleId);

    List<Integer> queryRoleHasAllMids(Integer roleId);

    //根据userId,查询角色，然后再查询所拥有的菜单
    List<String> queryUserHasRoleIdsHasModuleIds(Integer userId);

    //根据菜单Id,统计权限表
    Integer countPermissionByModuleId(Integer mid);

     Integer deletePermissionByModuleId(Integer mid);

}
