package com.wbs.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable示例
 *
 * @author: wangbingshuai
 * @create: 2020-02-12 10:14
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Callable接口要配合FutureTask使用
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start();
        // 2个线程调用同一个FutureTask，只会有一个得到执行
        new Thread(futureTask, "BB").start();
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());
        new Thread(futureTask2, "CC").start();

        int result1 = 100;
        // get()方法要放到最后，否则因为get()方法是阻塞的，会导致主线程或调用的线程堵塞
        int result2 = futureTask.get();
        System.out.println(Thread.currentThread().getName() + " result = " + (result1 + result2));
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t come in Callable *****");
        return 1024;
    }
}
