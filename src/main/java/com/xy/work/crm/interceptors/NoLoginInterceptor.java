package com.xy.work.crm.interceptors;

import com.xy.work.crm.exceptions.NoLoginException;
import com.xy.work.crm.service.impl.UserServiceImpl;
import com.xy.work.crm.utils.LoginUserUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 未登录拦截类，继承了HandlerIntercepterAdapter
 *
 *
 *     HandlerInterceptorAdapter中有三个方法：
 *     方别是preHandle，postHandle, afteCompletion。
 *     当我们需要使用的HandlerInterceptorAdapter实现相应的功能的时候（配置一个拦截器），
 *     就需要继承HandlerInterceptorAdapter，并实现其中相应的方法。
 *    三个方法的执行顺序为：preHandle-->postHanle-->afterCompletion
 *    三个方法的参数一样：
 *    HttpServletRequest request, HttpServletResponse response, Object handler
 *    HttpServletRequest request——包含所有请求的内容；
 *   HttpServletResponse response——包含所有响应的内容；
 *   Object handler——表示被拦截的请求的目标对象。
 *
 */
public class NoLoginInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private UserServiceImpl userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 非法请求拦截
         * 获取cookie解析用户Id 数据库存在对应记录
         */
        Integer id = LoginUserUtil.releaseUserIdFromCookie(request);
        if(id == 0 || null == userService.selectByPrimaryKey(id)){
           throw new NoLoginException();
        };



        return super.preHandle(request, response, handler);
    }
}
