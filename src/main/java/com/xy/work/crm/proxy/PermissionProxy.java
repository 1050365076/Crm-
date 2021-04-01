package com.xy.work.crm.proxy;

import com.xy.work.crm.annotaion.RequirePermission;
import com.xy.work.crm.exceptions.AuthException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;


//通过Aop，切面的方式来拦截注解菜单资源的访问

@Component
@Aspect
public class PermissionProxy {

    @Autowired
    private HttpSession session;

    /**
     * 通过环绕通知，来判断用户有没有访问权限
     * 拦截注解下的@RequirePermission
     */
    @Around(value = "@annotation(com.xy.work.crm.annotaion.RequirePermission)")
    public Object  around(ProceedingJoinPoint pjp) throws Throwable{
        Object result = null;
        //拿到注解中的权限码，匹配session里面的权限码
        List<String> pemissions = (List<String>) session.getAttribute("permissions");
        if(pemissions == null || pemissions.size() == 0){
            throw new AuthException();
        }
        //通过pjp获得当前的签名,拿到访问签名，然后拿到方法对应的权限码值
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        //拿到当前注解,从中获得code,判断是否存在集合中。
        RequirePermission requirePermission =  methodSignature.getMethod().getDeclaredAnnotation(RequirePermission.class);
        if(!pemissions.contains(requirePermission.code())){
            throw  new AuthException();
        }
        result = pjp.proceed();
        return result;
    }


}
