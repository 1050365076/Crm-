package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends BaseMapper<Role,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(Role record);

    Integer insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //查询所有角色
    List<Map<String,Object>> queryAllRoles(Integer userId);

   Role queryRoleByRoleName(String roleName);
}
