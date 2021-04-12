package com.xy.work.crm.query;

import com.xy.work.base.BaseQuery;

public class CustomerServeQuery extends BaseQuery {

    private String  customer;
    private Integer serverType;
    private String  state;
    private Integer assigner;


    public Integer getAssigner() {
        return assigner;
    }

    public void setAssigner(Integer assigner) {
        this.assigner = assigner;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
