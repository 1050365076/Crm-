package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.CustomerOrder;

import java.util.Map;

public interface CustomerOrderMapper extends BaseMapper<CustomerOrder,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(CustomerOrder record);

    Integer insertSelective(CustomerOrder record);

    CustomerOrder selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(CustomerOrder record);

    int updateByPrimaryKey(CustomerOrder record);

    Map<String,Object> queryCustomerOrderByOrderId (Integer orderId);
}
