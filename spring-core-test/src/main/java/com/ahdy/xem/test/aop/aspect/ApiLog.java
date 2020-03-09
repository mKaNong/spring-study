package com.ahdy.xem.test.aop.aspect;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ApiLog {
    String name() default "";
    boolean intoDb() default false;
}
