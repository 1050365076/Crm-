package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.RoleMapper;
import com.xy.work.crm.dao.UserRoleMapper;
import com.xy.work.crm.query.RoleQuery;
import com.xy.work.crm.service.RoleService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.vo.Role;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl  extends BaseService<Role,Integer> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

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
    public void deleteRole(Integer roleId) {
        /**
         * 1.参数校验
         * 非空，记录必须存在
         * 2.查询用户角色表纪录，如果存在子记录，删除子表记录
         * 3.执行角色删除操作
         **/
          Role role = selectByPrimaryKey(roleId);
          AssertUtil.isTrue( role == null ,"待删除的记录不存在！");
          int total = userRoleMapper.countUserRoleByRoleId(roleId);
          if(total > 0){
            AssertUtil.isTrue(  userRoleMapper.deleteUserRoleByRoleId(roleId) != total,"用户角色记录删除失败！");
          }
          role.setIsValid(0);
          AssertUtil.isTrue(updateByPrimaryKeySelective(role)<1,"角色记录删除失败！");
    }

    @Override
    public void updateRole(Role role) {
        /**
         * 1.参数校验
         *   角色名 非空 唯一
         * 2.默认参数的设置
         *  updateDate
         * 3.执行添加角色
         */
        AssertUtil.isTrue(StringUtils.isBlank(role.getRoleName()),"请输入角色名称！");
        Role temp = roleMapper.queryRoleByRoleName(role.getRoleName());
        AssertUtil.isTrue(temp != null && !(temp.getId().equals(role.getId()))  ,"该角色已经存在！");
        role.setUpdateDate(new Date());
        AssertUtil.isTrue(roleMapper.updateByPrimaryKeySelective(role)<1,"角色记录更新失败！");
    }

    @Override
    public void saveRole(Role role) {
        /**
         * 1.参数校验
         *   角色名 非空 唯一
         * 2.默认参数的设置
         *  is_valid
         *  createDatae
         *  updateDate
         * 3.执行添加角色
         */
        AssertUtil.isTrue(StringUtils.isBlank(role.getRoleName()),"请输入角色名称！");
        AssertUtil.isTrue(null != roleMapper.queryRoleByRoleName(role.getRoleName()),"该角色已经存在！");
        role.setIsValid(1);
        role.setCreateDate(new Date());
        role.setUpdateDate(new Date());
        AssertUtil.isTrue(roleMapper.insertSelective(role)<1,"角色记录添加失败！");
    }
}
