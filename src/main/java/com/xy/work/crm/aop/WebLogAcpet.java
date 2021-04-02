package com.xy.work.crm.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Aspect
@Component
public class WebLogAcpet {
        private Logger logger = LoggerFactory.getLogger(WebLogAcpet.class);

        /**
         * 定义切点，切入aop下面的的所有函数
         */
        @Pointcut("execution(public * com.xy.work.crm.aop.AopController.*(..))") //execution 匹配连接点
        public void webLog(){}

        /**
         * 前置通知：在连接点之前执行的通知
         * @param joinPoint
         * @throws Throwable
         */
        @Before("webLog()")
        public void doBefore(JoinPoint joinPoint) throws Throwable {
                // 接收到请求，记录请求内容
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();

                // 记录下请求内容
                System.out.println("在目标方法调用前做增强处理，@Before只需要指定切点");
                logger.info("URL : " + request.getRequestURL().toString());
                logger.info("HTTP_METHOD : " + request.getMethod());
                logger.info("IP : " + request.getRemoteAddr());
                logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
                logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        }

        @AfterReturning(returning = "ret", pointcut ="webLog()")
        public void doAfterReturning(Object ret) throws Throwable {
                // 处理完请求，返回内容
                System.out.println("在目标方法正常完成后做增强,@AfterReturning除了指定切入点表达式后，" +
                        "还可以指定一个返回值形参名returning,代表目标方法的返回值");
                logger.info("RESPONSE : " + ret);
        }
        @After("webLog()")
        public void after(){
                System.out.println("Aop After Advice 目标方法完成后增强");
        }

}
