package com.xy.work.crm.service;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.query.CustomerReprieveQuery;
import com.xy.work.crm.vo.CustomerReprieve;

import java.util.Map;

public interface CustomerReprieveService extends BaseMapper<CustomerReprieve,Integer> {

    Map<String,Object> queryByParams(CustomerReprieveQuery customerReprieveQuery);

    void deleteCustomerPer(Integer id);

    void saveCustomerRep(CustomerReprieve customerReprieve);

    void updateCustomerRep(CustomerReprieve customerReprieve);


}
