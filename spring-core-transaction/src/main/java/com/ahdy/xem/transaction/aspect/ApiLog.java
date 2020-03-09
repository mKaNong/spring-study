package com.ahdy.xem.transaction.aspect;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ApiLog {
    String name() default "";
    boolean intoDb() default false;
}
