package com.xy.work.base;


import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础父类控制器，当创建每一个控制器的时候继承改父类
 * 处理request请求，并且保存全局网页上下文 ctx;
 */
public class BaseController {


    @ModelAttribute
    public void preHandler(HttpServletRequest request){
        request.setAttribute("ctx", request.getContextPath());
    }


    public ResultInfo success(){
        return new ResultInfo();
    }

    public ResultInfo success(String msg){
        ResultInfo resultInfo= new ResultInfo();
        resultInfo.setMsg(msg);
        return resultInfo;
    }

    public ResultInfo success(String msg,Object result){
        ResultInfo resultInfo= new ResultInfo();
        resultInfo.setMsg(msg);
        resultInfo.setResult(result);
        return resultInfo;
    }

}
