package com.xy.work.base;

/**
 *
 * 返回参数的组合类，
 * code为成功代码
 * msg为成功消息
 * result为返回数据
 */
public class ResultInfo {

    private Integer code=200;
    private String msg="success";
    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
