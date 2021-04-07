package com.xy.work.crm.service;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.query.OrderDetailsQuery;
import com.xy.work.crm.vo.OrderDetails;

import java.util.Map;

public interface OrderDetailsService extends BaseMapper<OrderDetails,Integer> {

    Map<String,Object> queryByParams(OrderDetailsQuery orderDetailsQuery);
}
