package com.xy.work.crm.utils;

import com.xy.work.crm.exceptions.ParamsException;

/**
 * 参数异常判断，声明指定的参数消息
 */
public class AssertUtil {


    public  static void isTrue(Boolean flag,String msg){
        if(flag){
            throw  new ParamsException(msg);
        }
    }

}
