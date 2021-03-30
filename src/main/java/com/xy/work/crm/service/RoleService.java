package com.xy.work.crm.service;

import com.xy.work.crm.query.RoleQuery;
import com.xy.work.crm.vo.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Map<String,Object>> queryAllRoles(Integer userId);

    Map<String,Object> queryRoleByParams(RoleQuery roleQuery);

    void deleteRole(Integer roleId);

    void updateRole(Role role);

    void saveRole(Role role);
}
