package com.ahdy.xem.test.aop.aspect;

import com.ahdy.xem.log.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
@Order(99)
public class PrintLogAspect {

    @Pointcut("execution(* com.ahdy.xem.*..*.*(..))")
    public void print(){}

    @Before(value = "print() && @annotation(apiLog)")
    public void before(JoinPoint point, ApiLog apiLog) {
        System.out.println("Aop Before 1");
    }

    @After(value = "print() && @annotation(apiLog)")
    public void after(JoinPoint point, ApiLog apiLog) {
        System.out.println("Aop After 2");
    }

    /**
     * Around --> Before --> method --> After  --> Returning
     */
    @Around(value = "print() && @annotation(apiLog)")
    public Object round(ProceedingJoinPoint point, ApiLog apiLog) throws Throwable {
        System.out.println("Around环绕通知开始 日志记录begin");
        long start = System.currentTimeMillis();

        Object o = point.proceed();

        long end = System.currentTimeMillis();
        System.out.println("方法总共执行时长" + (end - start) + " 毫秒，返回 " + o);
        System.out.println("Around环绕通知结束 日志记录end");
        return o;
    }

    @AfterReturning(value = "print() && @annotation(log)")
    public void afterReturn(JoinPoint point, ApiLog log) {
        System.out.println("Aop AfterReturning 3");
    }

}
