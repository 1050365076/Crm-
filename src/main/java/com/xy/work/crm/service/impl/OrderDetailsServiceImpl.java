package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.OrderDetailsMapper;
import com.xy.work.crm.query.OrderDetailsQuery;
import com.xy.work.crm.service.OrderDetailsService;
import com.xy.work.crm.vo.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderDetailsServiceImpl extends BaseService<OrderDetails,Integer> implements OrderDetailsService {

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;


    @Override
    public Map<String, Object> queryByParams(OrderDetailsQuery orderDetailsQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(orderDetailsQuery.getPage(),orderDetailsQuery.getLimit());
        PageInfo<OrderDetails> pageInfo = new PageInfo<OrderDetails>(selectByParams(orderDetailsQuery));
        map.put("msg","");
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
}
