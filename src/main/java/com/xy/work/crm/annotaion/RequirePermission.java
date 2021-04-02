package com.xy.work.crm.annotaion;



import java.lang.annotation.*;

/**
 * 注解包，自定义一个注解，
 */
@Target({ElementType.METHOD})//注解目标在方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequirePermission {
    //权限码acleValue
    String code() default "";
}
