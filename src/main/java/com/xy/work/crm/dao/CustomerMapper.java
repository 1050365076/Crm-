package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.Customer;
import com.xy.work.crm.vo.Module;

import java.util.List;

public interface CustomerMapper extends BaseMapper<Customer,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    Integer insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);


    Customer queryCustomerByCusName (String cusName);


    List<Customer> queryLossCustomer();

    int updateCustomerStateByIds(List<Integer> lossCusIds);


}
