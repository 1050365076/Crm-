package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.CustomerServer;

public interface CustomerServerMapper extends BaseMapper<CustomerServer,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(CustomerServer record);

    Integer insertSelective(CustomerServer record);

    CustomerServer selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(CustomerServer record);

    int updateByPrimaryKey(CustomerServer record);
}
