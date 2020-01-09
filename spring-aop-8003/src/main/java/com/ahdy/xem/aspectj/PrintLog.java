package com.ahdy.xem.aspectj;

import com.ahdy.xem.annotation.WebLog;
import com.ahdy.xem.log.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * AOP可以理解为面向切面编程
 * 1. 可以简单地认为, 使用 @Aspect 注解的类就是切面
 * 2. Order是切面执行顺序，值越小，先执行
 */
@Component
@Aspect
@Order(100)
public class PrintLog {

    private static final Logger log = LogFactory.getBusLogger();
    private static final String START_TIME = "startTime";
    private static final String REQUEST_PARAMS = "requestParams";
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    /**
     * 一个 pointcut 的声明由两部分组成:
     *  1. 一个方法签名, 包括方法名和相关参数
     *  2. 一个 pointcut 表达式, 用来指定哪些方法执行是我们感兴趣的(即因此可以织入 advice).
     */
    @Pointcut("execution(* com.ahdy.xem.controller..*.*(..))")
    public void requestLog() {}

    @Before(value = "requestLog() && @annotation(webLog)")
    public void doBefore(JoinPoint joinPoint, WebLog webLog){
        long start = System.currentTimeMillis();
        Map<String, Object> threadInfoMap = new HashMap<String, Object>();
        threadInfoMap.put(START_TIME, start);
        Object[] args = joinPoint.getArgs();
        //String methodName = joinPoint.getSignature().getName();
        if(args != null && args.length > 0){
            StringBuilder sb = new StringBuilder();
            for (Object arg : args){
                sb.append(arg.toString());
            }
            threadInfoMap.put(REQUEST_PARAMS, sb.toString());
        }
        threadLocal.set(threadInfoMap);
        log.debug("{}接口开始调用:requestData={}", webLog.name(), threadInfoMap.get(REQUEST_PARAMS));
    }

    @AfterReturning(value = "requestLog() && @annotation(webLog)", returning = "res")
    public void doAfterReturning(WebLog webLog, Object res) {
        Map<String, Object> threadInfoMap = threadLocal.get();
        long time = System.currentTimeMillis() - (long)threadInfoMap.get(START_TIME);
        threadLocal.remove();
        log.debug("{}接口结束调用:耗时={}ms, result={}", webLog.name(), time, res);
    }

    @AfterThrowing(value = "requestLog() && @annotation(webLog)", throwing = "throwable")
    public void doAfterThrowing(WebLog webLog, Throwable throwable) {
        Map<String, Object> objectMap = threadLocal.get();
        threadLocal.remove();
        log.error("{}接口调用异常，异常信息{}", webLog.name(), throwable);
    }
}
