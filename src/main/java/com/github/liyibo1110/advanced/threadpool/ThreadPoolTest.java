package com.github.liyibo1110.advanced.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liyibo
 * @date 2025-10-17 15:10
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        SimpleThreadPool threadPool = new SimpleThreadPool(1, new ArrayBlockingQueue<>(2));

        for(int i = 1; i <= 4 ; i++) {
            int index = i;
            System.out.println("提交任务" + index + "START");
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "：任务" + index + "开始");
                sleep(3);
                System.out.println(Thread.currentThread().getName() + "：任务" + index + "结束");
            });
            System.out.println("提交任务" + index + "END");
        }
        sleep(100);
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("sleep exception");
        }
    }
}
