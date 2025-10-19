package com.github.liyibo1110.advanced.threadpool;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author liyibo
 * @date 2025-10-17 15:17
 */
public class ThreadPool1 {

    /** 任务队列 */
    private final BlockingQueue<Runnable> workQueue;

    /** 工作线程 */
    private final List<Worker> workers = new ArrayList<>();

    /** 线程数 */
    private final int poolSize;

    public ThreadPool1(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.poolSize = poolSize;
        this.workQueue = workQueue;
    }

    public void execute(Runnable task) {
        if(workers.size() < poolSize) {
            this.addWorker(task);
            return;
        }
        boolean enqueued = workQueue.offer(task);
        if(!enqueued)
            throw new RuntimeException("触发拒绝策略");
    }

    private void addWorker(Runnable task) {
        Worker worker = new Worker(task);
        workers.add(worker);
        worker.getThread().start();
    }

    private Runnable getTaskFromQueue() {
        try {
            return workQueue.take();
        } catch (InterruptedException e) {
            return null;
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
            while(task != null || (task = getTaskFromQueue()) != null) {
                task.run();
                task = null;
            }
        }
    }
}
