package com.xy.work.crm.enums;

public enum CustomerServeStatus {
    //创建
    CREATE("fw_001"),
    //分配
    ASSIGNED("fw_002"),
    //处理
    PROCED("fw_003"),
    //反馈
    FEE_BACK("fw_004"),
    //归档
    ARCHIVED("fw_005");

    private String state;

    CustomerServeStatus(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
