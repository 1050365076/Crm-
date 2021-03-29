package com.xy.work.crm.service;


import com.xy.work.crm.query.CusDevPlanQuery;
import com.xy.work.crm.vo.CusDevPlan;

import java.util.Map;

public interface CusDevPlanService {
    /**
     * 分页查询
     * @param cusDevPlanQuery
     * @return
     */
    public Map<String,Object> queryCusDevPlanByParams(CusDevPlanQuery cusDevPlanQuery);

    /**
     * 新增客户开发计划
     * @param cusDevPlan
     */
    public void saveCusDetPlan(CusDevPlan cusDevPlan);


    public void updateCusDevPlan(CusDevPlan cusDevPlan);

    public void deleteCusDevPlan(Integer id);

}
