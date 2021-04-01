package com.xy.work.crm;

import com.alibaba.fastjson.JSON;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.exceptions.AuthException;
import com.xy.work.crm.exceptions.NoLoginException;
import com.xy.work.crm.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局异常捕获，请求的时候，
 * DispatcherServlet掌管Handler,对应的HandlerMapper
 */
@Component //单例对象交给IOC
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        /**
         * 处理全局异常
         * 方法返回值类型
         *      视图
         *      json
         * 判断返回是否是视图，还是JSON
         *  方法级别是否配置@ResponseBody 方法响应内容为JSON 反正响应内容为HTML页面
         */
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/error");
        mv.addObject("code", 400);
        mv.addObject("msg", "系统异常请稍后再试....");

        if(e instanceof NoLoginException){
            mv.setViewName("no_login");
            mv.addObject("msg", "用户未登录！");
            mv.addObject("ctx",httpServletRequest.getContextPath());
           return mv;
        }


        if (o instanceof HandlerMethod) {
            /**
             * Spring MVC应用启动时会搜集并分析每个Web控制器方法，
             * 从中提取对应的"<请求匹配条件,控制器方法>“映射关系，
             * 形成一个映射关系表保存在一个RequestMappingHandlerMapping bean中。
             * 然后在客户请求到达时，
             * 再使用RequestMappingHandlerMapping中的该映射关系表找到相应的控制器方法去处理该请求。
             * 在RequestMappingHandlerMapping中保存的每个”<请求匹配条件,控制器方法>"映射关系对儿中,
             * "请求匹配条件"通过RequestMappingInfo包装和表示，
             * 而"控制器方法"则通过HandlerMethod来包装和表示。
             * 一个HandlerMethod对象，可以认为是对如下信息的一个包装 :
             */
            HandlerMethod hm = (HandlerMethod) o;
            ResponseBody responseBody = hm.getMethod().getDeclaredAnnotation(ResponseBody.class);
            if (responseBody == null) {
                /**
                 * 如果没有该注解方法返回的内容为视图
                 */
                if (e instanceof ParamsException) {
                    ParamsException paramsException = (ParamsException) e;
                    mv.addObject("msg", paramsException.getMsg());
                    mv.addObject("code", paramsException.getCode());
                } else if(e instanceof AuthException){
                    AuthException authException = (AuthException) e;
                    mv.addObject("msg", authException.getMsg());
                    mv.addObject("code", authException.getCode());
                }
                return mv;
            } else {
                /**
                 * 响应为Json
                 */
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setCode(300);
                resultInfo.setMsg("系统错误请稍后再试....");
                /**
                 * 判断异常是否是参数异常,json
                 */
                if (e instanceof ParamsException) {
                    ParamsException p = (ParamsException) e;
                    resultInfo.setMsg(p.getMsg());
                    resultInfo.setCode(p.getCode());
                }else if(e instanceof AuthException) {
                    AuthException authException = (AuthException) e;
                    resultInfo.setMsg(authException.getMsg());
                    resultInfo.setCode(authException.getCode());
                }
                    /**
                 * 错误信息以JSON信息写到客户端
                 */
                httpServletResponse.setContentType("application/json;charset=utf-8");
                httpServletResponse.setCharacterEncoding("utf-8");

                PrintWriter pw = null;
                try {
                    //拿到打印流，向浏览器写出JSON
                    pw = httpServletResponse.getWriter();
                    pw.write(JSON.toJSONString(resultInfo));
                    pw.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    if (null != pw) {
                        pw.close();
                    }
                }
                return null;
            }
        } else {
            return mv;
        }
    }


}
