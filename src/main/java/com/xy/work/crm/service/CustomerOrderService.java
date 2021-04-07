package com.xy.work.crm.service;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.query.CustomerOrderQuery;
import com.xy.work.crm.vo.CustomerOrder;

import java.util.Map;

public interface CustomerOrderService extends BaseMapper<CustomerOrder,Integer>  {

    Map<String,Object> querybyParams(CustomerOrderQuery customerOrderQuery);


    Map<String,Object>queryCustomerOrderByOrderId(Integer orderId);
}
