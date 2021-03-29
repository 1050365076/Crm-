package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(UserRole record);

    Integer insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    Integer  updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    //根据用户Id,查询出用户角色记录
     int countUserRoleByUserId(Integer userId);
    //根据用户Id,删除用户记录
     int deleteUserRoleByUserId(Integer userId);
}
