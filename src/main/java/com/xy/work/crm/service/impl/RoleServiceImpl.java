package com.xy.work.crm.service.impl;

import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.RoleMapper;
import com.xy.work.crm.service.RoleService;
import com.xy.work.crm.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl  extends BaseService<Role,Integer> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Map<String, Object>> queryAllRoles() {
        return roleMapper.queryAllRoles();
    }
}
