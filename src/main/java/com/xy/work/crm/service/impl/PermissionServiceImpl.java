package com.xy.work.crm.service.impl;

import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.PermissionMapper;
import com.xy.work.crm.service.PermissionService;
import com.xy.work.crm.vo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl extends BaseService<Permission,Integer> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<String> queryUserHasRoleIdsHasModuleIds(Integer userId) {
        return permissionMapper.queryUserHasRoleIdsHasModuleIds(userId);
    }
}
