package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.CustomerLoss;

public interface CustomerLossMapper extends BaseMapper<CustomerLoss,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(CustomerLoss record);

    Integer insertSelective(CustomerLoss record);

    CustomerLoss selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(CustomerLoss record);

    int updateByPrimaryKey(CustomerLoss record);
}
