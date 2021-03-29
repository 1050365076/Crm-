package com.xy.work.crm.config;


import com.xy.work.crm.interceptors.NoLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * ** 解决跨域问题 **/
// *public void addCorsMappings(CorsRegistry registry);
//        *
//        * /** 添加拦截器 **/
//        *void addInterceptors(InterceptorRegistry registry);
//        *
//        * /** 这里配置视图解析器 **/
//        *void configureViewResolvers(ViewResolverRegistry registry);
//        *
//        * /** 配置内容裁决的一些选项 **/
//        *void configureContentNegotiation(ContentNegotiationConfigurer configurer);
//        *
//        * /** 视图跳转控制器 **/
//        *void addViewControllers(ViewControllerRegistry registry);
//        *
//        * /** 静态资源处理 **/
//        *void addResourceHandlers(ResourceHandlerRegistry registry);
//        *
//        * /** 默认静态资源处理器 **/
//        *void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);
//
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public NoLoginInterceptor noLoginInterceptor(){
        return  new NoLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 通过拦截器拦截静态资源
         *
         */
        registry.addInterceptor(noLoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index",
                        "/user/login",
                        "/css/**","/images/**","/js/**","/lib/**");
    }
}
