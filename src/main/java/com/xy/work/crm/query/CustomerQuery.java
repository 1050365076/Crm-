package com.xy.work.crm.query;

import com.xy.work.base.BaseQuery;

public class CustomerQuery extends BaseQuery {

    private String cusName;

    private String cusNo;

    private String level;

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
