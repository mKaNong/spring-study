package com.ahdy.xem.thread;

import lombok.Synchronized;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*Thread t = new Thread(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("currentThread isInterrupted...");
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted When Sleep...");
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        t.interrupt();*/
       /* Thread t1 = new T1();
        t1.start();

        Thread t2 = new T2();
        t2.start();
        t1.join(111);*/

        Thread t1 = new Thread_1();
        t1.start();

        Thread t2 = new Thread(new Thread_2());
        t2.start();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Thread_3());
        Integer n = future.get();
        System.out.println(n);
    }

    final static Object obj = new Object();
    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (obj){
                System.out.println(System.currentTimeMillis() + " t1 start...");
                try {
                    System.out.println(System.currentTimeMillis() + " t1 wait...");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " t1 end...");
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (obj){
                System.out.println(System.currentTimeMillis() + " t2 start...");
                obj.notify();
                System.out.println(System.currentTimeMillis() + " t2 end...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Thread_1 extends Thread {
    @Override
    public void run() {
        System.out.println("thread 1 run...");
    }
}

class Thread_2 implements Runnable {
    @Override
    public void run() {
        System.out.println("thread 2 run...");
    }
}

class Thread_3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("thread 3 run...");
        return 666666;
    }
}
