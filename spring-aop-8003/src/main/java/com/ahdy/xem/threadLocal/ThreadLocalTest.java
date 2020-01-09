package com.ahdy.xem.threadLocal;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        new Thread(() -> {
            threadLocal.set("1");
            System.out.println(threadLocal.get());
        }).start();
        new Thread(() -> {
            threadLocal.set("2");
            System.out.println(threadLocal.get());
        }).start();


    }

    public static SimpleDateFormat getSimpleDateFormat(){
        new ThreadLocal<SimpleDateFormat>(){
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd");
            }
        };
        return null;
    }
}
