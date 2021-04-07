package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.OrderDetails;

import java.util.Map;

public interface OrderDetailsMapper extends BaseMapper<OrderDetails,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(OrderDetails record);

    Integer insertSelective(OrderDetails record);

    OrderDetails selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(OrderDetails record);

    int updateByPrimaryKey(OrderDetails record);


}
