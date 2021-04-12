package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper extends BaseMapper<User,Integer> {

    Integer deleteByPrimaryKey(Integer id);

    int insert(User record);

    Integer insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUserByName(String userName);

    //查询所以指派人。销售
    public List<Map<String,Object>> queryAllSale();

    //查询所以指派人。销售
    public List<Map<String,Object>> queryAllCustomerManager();
}
