package com.zhao.rocketmq.quickstart;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadTest {
    public static class Task implements Callable<String> {
        public String call() throws Exception {
            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.printf("Thread#%s : in call\n", tid);
            return tid;
        }
    }

    static Callable<Integer> test3 = new Callable<Integer>() {
        public Integer call() throws Exception {
            return new Random().nextInt(100);
        }
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fixThreadPool = Executors.newFixedThreadPool(1);
        Future<Integer> future2 = fixThreadPool.submit(test3);
        System.out.println(future2.get());
        fixThreadPool.shutdown();
    }

}
