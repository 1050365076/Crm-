package com.xy.work.crm.service.impl;

import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.ModuleMapper;
import com.xy.work.crm.dao.PermissionMapper;
import com.xy.work.crm.model.TreeDto;
import com.xy.work.crm.service.ModuleService;
import com.xy.work.crm.vo.Module;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl extends BaseService<Module,Integer> implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<TreeDto> queryAllModules(Integer roleId) {
       List<TreeDto> treeDtos = moduleMapper.queryAllModuls();
       //查询角色以及分配的菜单Id
        List<Integer> mids = permissionMapper.queryRoleHasAllMids(roleId);
        //遍历所以菜单，以及查询角色拥有的菜单，当角色拥有菜单时，checked==true
        if( mids != null && mids.size()>0){
                treeDtos.forEach(treeDto -> {
                    if(mids.contains(treeDto.getId())){
                        //改角色以及分配菜单
                        treeDto.setChecked(true);
                        treeDto.setOpen(true);
                    }
                });
        }
        return treeDtos;
    }
}
