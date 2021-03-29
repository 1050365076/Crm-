package com.xy.work.crm.query;

import com.xy.work.base.BaseQuery;

/**
 * 多条件查询类，声明需要的参数
 */
public class CusDevPlanQuery extends BaseQuery {
    //营销机会参数
    private Integer sid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
