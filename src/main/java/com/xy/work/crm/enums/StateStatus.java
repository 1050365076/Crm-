package com.xy.work.crm.enums;

public enum StateStatus {
    //未分配
    UNSTATE(0),
    //已分配
    STATED(1);


    private Integer type;

    StateStatus(Integer type) {this.type = type; }

    public Integer getType() { return type; }
}
