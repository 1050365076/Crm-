package com.xy.work.crm.query;

import com.xy.work.base.BaseQuery;

public class CustomerQuery extends BaseQuery {

    private String cusName;

    private String cusNo;

    private String level;

    private String time;

    //金额区间类型 1： 0-1000  2：1000-3000  3:3000-5000 4：5000+
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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
