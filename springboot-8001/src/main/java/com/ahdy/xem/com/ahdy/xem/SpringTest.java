package com.ahdy.xem.com.ahdy.xem;

import java.util.Arrays;

public class SpringTest {

    public static void main(String[] args) {
        Class cls = deduceClass("main");
        System.out.println(cls);
    }

    private static Class<?> deduceClass (String MethodName) {
        if(MethodName == null){
            return null;
        }
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        try {
            for(StackTraceElement stackTraceElement : stackTrace){
                if(MethodName.equals(stackTraceElement.getMethodName())){
                    return Class.forName(stackTraceElement.getClassName());
                }
            }
        } catch (ClassNotFoundException e) {
            ;
        }
        return null;
    }

}
