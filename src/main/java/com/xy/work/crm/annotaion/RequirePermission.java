package com.xy.work.crm.annotaion;



import java.lang.annotation.*;

/**
 * 注解包，定义一个注解，用来后台控制菜单
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequirePermission {
    //权限码acleValue
    String code() default "";
}
