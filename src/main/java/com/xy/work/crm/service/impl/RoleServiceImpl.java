package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.RoleMapper;
import com.xy.work.crm.query.RoleQuery;
import com.xy.work.crm.service.RoleService;
import com.xy.work.crm.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl  extends BaseService<Role,Integer> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Map<String, Object>> queryAllRoles(Integer userId) {
        return roleMapper.queryAllRoles(userId);
    }

    @Override
    public Map<String, Object> queryRoleByParams(RoleQuery roleQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(roleQuery.getPage(),roleQuery.getLimit());
        PageInfo<Role> pageInfo = new PageInfo<Role>(selectByParams(roleQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    @Override
    public void deleteRole(Role role) {

    }

    @Override
    public void updateRole(Role role) {

    }
}
