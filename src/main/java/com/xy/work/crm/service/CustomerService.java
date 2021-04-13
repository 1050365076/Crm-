package com.xy.work.crm.service;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.query.CustomerQuery;
import com.xy.work.crm.vo.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService extends BaseMapper<Customer,Integer>  {

    Map<String,Object> queryCustomerByParams(CustomerQuery customerQuery);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Integer id);

    void updateCustomerState();

    Map<String,Object> queryCustomerContributionByParams(CustomerQuery customerQuery);

    Map<String,Object> countCustomerMake();

    Map<String,Object> countCustomerMake02();


}
