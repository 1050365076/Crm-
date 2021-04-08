package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.CustomerReprieve;

public interface CustomerReprieveMapper extends BaseMapper<CustomerReprieve,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(CustomerReprieve record);

    Integer insertSelective(CustomerReprieve record);

    CustomerReprieve selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(CustomerReprieve record);

    int updateByPrimaryKey(CustomerReprieve record);

    

}
