package com.xy.work.crm.service.impl;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.UserMapper;
import com.xy.work.crm.dao.UserRoleMapper;
import com.xy.work.crm.model.UserModel;
import com.xy.work.crm.query.UserQuery;
import com.xy.work.crm.service.UserService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.utils.Md5Util;
import com.xy.work.crm.utils.PhoneUtil;
import com.xy.work.crm.utils.UserIDBase64;
import com.xy.work.crm.vo.User;
import com.xy.work.crm.vo.UserRole;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl extends BaseService<User,Integer> implements UserService {

    @Autowired
    private  UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserModel login(String userName, String userPwd) {

        checkLoginParam(userName,userPwd);
        User user = userMapper.queryUserByName(userName);
        AssertUtil.isTrue(null == user,"用户不存在或者已经注销");
        AssertUtil.isTrue(!(user.getUserPwd().equals(Md5Util.encode(userPwd))),"用户密码不正确,请重新输入");

        return buildUserInfo(user);
    }

    @Override
    public List<Map<String, Object>> queryAllSale() {
        return userMapper.queryAllSale();
    }


    @Override
    public Map<String, Object> queryUsersbyParams(UserQuery userQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(userQuery.getPage(),userQuery.getLimit());
        PageInfo<User> pageInfo = new PageInfo<User>( selectByParams(userQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    /**
     * 添加User
     * @param user
     */
    @Override
    public void saveUser(User user) {
        /**
         * 1.参数校验
         *     用户名 非空 唯一
         *     email 非空 合法
         *     手机  非空 合法
         * 2.默认参数的设置
         *      is_Vali 1
         *      createDate
         *      updateDate
         *      默认密码 123456
         * 3.执行添加
         */

        checkFormParams(user.getUserName(),user.getEmail(),user.getPhone());
        AssertUtil.isTrue(null !=userMapper.queryUserByName(user.getUserName()),"用户名不能重复！");
        user.setIsValid(1);
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        user.setUserPwd(Md5Util.encode("123456"));
        AssertUtil.isTrue(insertSelective(user)<1,"用户记录添加失败！");

        //用户角色管理（t_user_role） user_id role_id
        //获取添加用户Id
        Integer userId = userMapper.queryUserByName(user.getUserName()).getId();
        String roleIds = user.getRoleIds();
        /**
         * 批量添加用户角色记录 进入用户角色表
         */
        relationUserRoles(userId,roleIds);
    }

    /**
     * 用户角色关联，批量添加用户角色
     * @param userId
     * @param roleIds
     */
    private void relationUserRoles(Integer userId, String roleIds) {

        /**
         *  适用添加，适用修改
         * **推荐方案** 首先将用户角色记录删除(存在的情况) 然后加入修改后的用户角色（选择角色记录）
         */
        int total = userRoleMapper.countUserRoleByUserId(userId);
        if(total>0){
           AssertUtil.isTrue(userRoleMapper.deleteUserRoleByUserId(userId) != total,"用户角色记录关联失败！ ");
        }
        if(StringUtils.isNotBlank(roleIds)){
                List<UserRole> userRoles = new ArrayList<UserRole>();
                for (String s : roleIds.split(",")){
                    UserRole userRole = new UserRole();
                    userRole.setCreateDate(new Date());
                    userRole.setUpdateDate(new Date());
                    userRole.setRoleId(Integer.parseInt(s));
                    userRole.setUserId(userId);
                    userRoles.add(userRole);
                }
               AssertUtil.isTrue(userRoleMapper.insertBatch(userRoles)!=userRoles.size(),"用户角色记录关联失败！") ;
            }
    }

    /**
     * 修改User
     * @param user
     */
    @Override
    public void updateUser(User user) {
        /**
         * 1.参数校验
         *      id存在
         *     用户名 非空 唯一
         *     email 非空 合法
         *     手机  非空 合法
         * 2.默认参数的设置
         * updateDate
         *
         * 3.执行更新
         */
        User temp = selectByPrimaryKey(user.getId());
        AssertUtil.isTrue(temp == null,"待更新用户记录不存在！");
        checkFormParams(user.getUserName(),user.getEmail(),user.getPhone());
        temp = userMapper.queryUserByName(user.getUserName());
        AssertUtil.isTrue((null != temp)&&!temp.getId().equals(user.getId()),"该用户已经存在!");
        user.setUpdateDate(new Date());
        AssertUtil.isTrue(updateByPrimaryKeySelective(user)<1,"用户记录修改失败！");


        /**
         *     用户角色管理（t_user_role） user_id role_id
         *     修改
         *     用户修改
         *     存在
         *         81 （1,2）--->81 null
         *         81 (1,2)--->81 1,2,3,4
         *         81 (1,2)--->81 2
         *     不存在
         *     直接批量添加（选择角色记录）
         * **推荐方案** 首先将用户角色记录删除(存在的情况) 然后加入修改后的用户角色（选择角色记录）
         */

        relationUserRoles(user.getId(),user.getRoleIds());


    }


    @Override
    public void deleteUser(Integer[] ids) {
            AssertUtil.isTrue(null == ids|| ids.length == 0 ,"请选择待删除的用户记录!");
            AssertUtil.isTrue(deleteBatch(ids) != ids.length,"用户记录删除失败!");
    }

    private void checkFormParams(String userName, String email, String phone) {
        AssertUtil.isTrue(StringUtils.isBlank(userName),"请输入用户名！");
        AssertUtil.isTrue(StringUtils.isBlank(email),"请输入邮箱！");
        AssertUtil.isTrue(!PhoneUtil.isMobile(phone),"请输入正确的手机号！");
    }

    /**
     * 构建需要用到的用户信息
     * @param user
     */
    private UserModel buildUserInfo(User user) {

        UserModel userModel = new UserModel();
        userModel.setUserIdstr(UserIDBase64.encoderUserID(user.getId()));
        userModel.setUserName(user.getUserName());
        userModel.setTrueName(user.getTrueName());
        return  userModel;
    }


    /**
     * 用户参数校验
     * @param userName
     * @param userPwd
     */
    private void checkLoginParam(String userName, String userPwd) {
        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(userPwd),"用户密码不能为空");
    }


    /**
     * 用户修改密码
     */

    public void updateUserPwd(Integer userId,String oldPassword,String newPassword,String cofirmPassword){
        /**
         * 1.参数校验
         * 2.设置用户新密码
         * 3.执行更新操作
         */

        checkParams(userId,oldPassword,newPassword,cofirmPassword);
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserPwd(Md5Util.encode(newPassword));
        AssertUtil.isTrue(updateByPrimaryKeySelective(user)<1,"用户密码更新失败!");
    }

    /**
     * 修改密码参数校验
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @param cofirmPassword
     */
    private void checkParams(Integer userId,String oldPassword,String newPassword,String cofirmPassword) {
        User tmp = userMapper.selectByPrimaryKey(userId);
        AssertUtil.isTrue(null == userId || null == tmp,"用户未登录或不存在！");
        AssertUtil.isTrue(StringUtils.isBlank(oldPassword),"请输入原始密码！");
        AssertUtil.isTrue(StringUtils.isBlank(newPassword),"请输入新密码！");
        AssertUtil.isTrue(StringUtils.isBlank(cofirmPassword),"请输入确认密码！");
        AssertUtil.isTrue(!(tmp.getUserPwd().equals(Md5Util.encode(oldPassword))),"原始密码不正确!");
        AssertUtil.isTrue(!(newPassword.equals(cofirmPassword)),"新密码输入不一致!");
        AssertUtil.isTrue((Md5Util.encode(newPassword).equals(tmp.getUserPwd())),"新密码不能和原始密码一致！");


    }
}
