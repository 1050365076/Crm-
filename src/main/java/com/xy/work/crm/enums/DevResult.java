package com.xy.work.crm.enums;


/**
 * 枚举类，用来保存 营销机会开发的状态
 */

public enum DevResult {
    //未开发
    UNDEV(0),
    //开发中
    DEVING(1),
    //开发成功
    DEV_SUCCESS(2),
    //开发失败
    DEV_FAILED(3);


    private Integer status;



    DevResult(Integer status) { this.status = status;}

    public Integer getStatus() { return status;}


}
