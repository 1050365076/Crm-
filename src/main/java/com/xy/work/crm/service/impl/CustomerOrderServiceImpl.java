package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.CustomerOrderMapper;
import com.xy.work.crm.query.CustomerOrderQuery;
import com.xy.work.crm.service.CustomerOrderService;
import com.xy.work.crm.vo.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerOrderServiceImpl extends BaseService<CustomerOrder,Integer> implements CustomerOrderService {

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @Override
    public Map<String, Object> querybyParams(CustomerOrderQuery customerOrderQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(customerOrderQuery.getPage(),customerOrderQuery.getLimit());
        PageInfo<CustomerOrder> pageInfo = new PageInfo<>(selectByParams(customerOrderQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    @Override
    public Map<String, Object> queryCustomerOrderByOrderId(Integer orderId) {

        return   customerOrderMapper.queryCustomerOrderByOrderId(orderId);
    }
}
