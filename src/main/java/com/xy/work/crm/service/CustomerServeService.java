package com.xy.work.crm.service;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.query.CustomerServeQuery;
import com.xy.work.crm.vo.CustomerServer;

import java.util.Map;

public interface CustomerServeService extends BaseMapper<CustomerServer,Integer> {
    Map<String,Object> queryByParams(CustomerServeQuery serveQuery);

    void saveCustomerServe (CustomerServer customerServer);

    void updateCustomerServe(CustomerServer customerServer);

    Map<String,Object> countCustomerServe();

    Map<String,Object> countCustomerServe02();

}
