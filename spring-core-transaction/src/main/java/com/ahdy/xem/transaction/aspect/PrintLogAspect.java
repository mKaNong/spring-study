package com.ahdy.xem.transaction.aspect;

import com.ahdy.xem.log.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(99)
public class PrintLogAspect {

    private static Logger log = LogFactory.getBusLogger();

    @Pointcut("execution(* com.ahdy.xem.transaction.*..*.*(..))")
    public void print(){}

    /*@Before(value = "print() && @annotation(apiLog)")
    public void before(JoinPoint point, ApiLog apiLog) {
        System.out.println("Aop Before 1");
    }

    @After(value = "print() && @annotation(apiLog)")
    public void after(JoinPoint point, ApiLog apiLog) {
        System.out.println("Aop After 2");
    }*/

    /**
     * Around --> Before --> method --> After  --> Returning
     */
    @Around(value = "print() && @annotation(apiLog)")
    public Object round(ProceedingJoinPoint point, ApiLog apiLog) throws Throwable {
        log.debug("调用方法 : " + apiLog.name());
        long start = System.currentTimeMillis();
        Object o = point.proceed();
        long end = System.currentTimeMillis();
        log.debug("方法总共执行时长" + (end - start) + " 毫秒，返回 " + o);
        return o;
    }

   /* @AfterReturning(value = "print() && @annotation(log)")
    public void afterReturn(JoinPoint point, ApiLog log) {
        System.out.println("Aop AfterReturning 3");
    }*/

   @AfterThrowing(value = "print() && @annotation(apiLog)", throwing = "error")
   public void afterThrowing(JoinPoint point, ApiLog apiLog, Throwable error) {
       Signature method = point.getSignature();
       log.error("method {} exception : ", method , error);
   }

}
