package com.xy.work.crm.service.impl;

import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.ModuleMapper;
import com.xy.work.crm.dao.PermissionMapper;
import com.xy.work.crm.model.TreeDto;
import com.xy.work.crm.service.ModuleService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.vo.Module;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //查询所有的菜单
    @Override
    public Map<String, Object> queryModuls() {
        Map<String,Object> result = new HashMap<>();
        List<Module> moduleList =  moduleMapper.queryModuls();
        result.put("count",moduleList.size());
        result.put("code",0);
        result.put("msg","");
        result.put("data",moduleList);
        return result;
    }
    //添加菜单
    @Override
    public void saveModule(Module module) {
        /**
         * 1.参数校验
         *      菜单名
         *      非空 同一层级 菜单名唯一
         *      url
         *      二级菜单时 非空 不可重复
         *      上级菜单parentId
         *          一级菜单 parentId(-1),
         *          二级/三级菜单 parentId(非空) 上级菜单必须存在
         *      菜单层级 grade
         *          非空 0|1|2
         *      权限码optValue
         *          非空 不可以重复
         *  2.参数默认值
         *  3.执行添加
          */
        AssertUtil.isTrue(StringUtils.isBlank(module.getModuleName()),"请输入菜单名！");
        Integer grade = module.getGrade();
        //同一层级下，菜单名不能为空,不能重复
        AssertUtil.isTrue(null == grade || !(grade == 0|| grade ==1 || grade == 2),"菜单层级非法！");
        Module m  = moduleMapper.queryModuleByGradeAndModuleName(grade,module.getModuleName());
        AssertUtil.isTrue(m!=null,"该层级下菜单名已经存在！");
        //二级菜单下,url不能为空，不能重复
        if(grade == 1){
            AssertUtil.isTrue(StringUtils.isBlank(module.getUrl()),"请输入二级菜单地址Url");
            m = moduleMapper.queryModuleByGradeAndUrl(grade,module.getUrl());
            AssertUtil.isTrue(m != null,"二级菜单下的Url不可重复！");
        }
        //二级、三级菜单，必须指定上级菜单id
        if(grade != 0){
            AssertUtil.isTrue( null == module.getParentId() || null == selectByPrimaryKey(module.getParentId()),"请指定上级菜单！");
        }
        //权限码
        AssertUtil.isTrue(StringUtils.isBlank(module.getOptValue()),"请输入菜单权限码！");
         m = moduleMapper.queryModuleByOptValue(module.getOptValue());
        AssertUtil.isTrue(null != m,"权限码重复！");
        module.setIsValid((byte)1);
        module.setCreateDate(new Date());
        module.setUpdateDate(new Date());
        AssertUtil.isTrue(insertSelective(module)<1,"菜单添加失败！");
    }

}
