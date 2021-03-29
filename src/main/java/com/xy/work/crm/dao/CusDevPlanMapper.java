package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.CusDevPlan;

public interface CusDevPlanMapper extends BaseMapper<CusDevPlan,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(CusDevPlan record);

    Integer insertSelective(CusDevPlan record);

    CusDevPlan selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(CusDevPlan record);

    int updateByPrimaryKey(CusDevPlan record);
}
