package com.xy.work.crm.service;


import com.xy.work.crm.model.UserModel;
import com.xy.work.crm.query.UserQuery;
import com.xy.work.crm.vo.CusDevPlan;
import com.xy.work.crm.vo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public UserModel login(String userName, String userPwd);

    //查询所以指派人。销售
    public List<Map<String,Object>> queryAllSale();

    public Map<String,Object> queryUsersbyParams(UserQuery userQuery);

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer [] ids);
}
