package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.CustomerReprieveMapper;
import com.xy.work.crm.query.CustomerReprieveQuery;
import com.xy.work.crm.service.CustomerReprieveService;
import com.xy.work.crm.vo.CustomerReprieve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CustomerReprieveServiceImpl extends BaseService<CustomerReprieve,Integer> implements CustomerReprieveService {

    @Autowired
    private CustomerReprieveMapper customerReprieveMapper;


    @Override
    public Map<String, Object> queryByParams(CustomerReprieveQuery customerReprieveQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(customerReprieveQuery.getPage(),customerReprieveQuery.getLimit());
        PageInfo<CustomerReprieve> pageInfo = new PageInfo<CustomerReprieve>(selectByParams(customerReprieveQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
}
