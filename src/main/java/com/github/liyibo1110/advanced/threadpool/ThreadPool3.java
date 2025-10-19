package com.github.liyibo1110.advanced.threadpool;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyibo
 * @date 2025-10-17 16:07
 */
public class ThreadPool3 {

    /** 对线程池中的线程计数 */
    private final AtomicInteger ctl = new AtomicInteger(0);

    /** 任务队列 */
    private final BlockingQueue<Runnable> workQueue;

    /** 工作线程 */
    private final List<Worker> workers = new ArrayList<>();

    /** 核心线程数 */
    private final int corePoolSize;

    /** 最大线程数 */
    private final int maximumPoolSize;

    /** 非核心线程最大空闲时间 */
    private final long keepAliveTime;

    public ThreadPool3(int corePoolSize,
                       int maximumPoolSize,
                       long keepAliveTime,
                       TimeUnit timeUnit,
                       BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = timeUnit.toNanos(keepAliveTime);
    }

    public void execute(Runnable task) {
        Assert.notNull(task, "task is null.");
        if(ctl.get() < corePoolSize) {
            this.addWorker(task, true); // 创建core线程
            return;
        }

        boolean enqueued = workQueue.offer(task);
        if(enqueued)
            return;

        if(!this.addWorker(task, false))    // 创建非core线程
            throw new RuntimeException("触发拒绝策略");
    }

    private boolean addWorker(Runnable task, boolean core) {
        while(true) {
            if(ctl.get() >= (core ? corePoolSize : maximumPoolSize))
                return false;
            if(compareAndIncrementWorkerCount(ctl.get()))
                break;
        }

        Worker worker = new Worker(task);
        workers.add(worker);
        worker.getThread().start();
        return true;
    }

    private Runnable getTaskFromQueue() {
        boolean timedOut = false;
        while(true) {
            // 池中线程数超过core，则尝试销毁部分线程
            boolean tryDestroy = ctl.get() > corePoolSize;
            if(tryDestroy && timedOut) {
                if(compareAndDecrementWorkerCount(ctl.get()))
                    return null;
                continue;
            }

            try {
                Runnable r = tryDestroy ?
                        workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
                        workQueue.take();
                if(r != null)
                    return r;
                timedOut = true;
            } catch (InterruptedException retry) {
                timedOut = false;
            }
        }
    }

    @Getter
    @Setter
    private class Worker implements Runnable {
        private Thread thread;
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            try {
                while(task != null || (task = getTaskFromQueue()) != null) {
                    task.run();
                    task = null;
                }
            } finally {
                // 到这里面，说明线程空闲并且池中线程数大于core
                System.out.println(thread.getName() + "被销毁");
                workers.remove(this);
            }
        }
    }

    private boolean compareAndIncrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect + 1);
    }

    private boolean compareAndDecrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect - 1);
    }
}
