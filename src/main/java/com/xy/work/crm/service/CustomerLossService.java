package com.xy.work.crm.service;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.query.CustomerLossQuery;
import com.xy.work.crm.vo.CustomerLoss;

import java.util.Map;

public interface CustomerLossService extends BaseMapper<CustomerLoss,Integer> {

    Map<String,Object> queryByParams(CustomerLossQuery customerLossQuery);
}
