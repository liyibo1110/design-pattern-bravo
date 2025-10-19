package com.github.liyibo1110.advanced.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author liyibo
 * @date 2025-10-17 15:06
 */
@Slf4j
public class SimpleThreadPool {

    /** 任务队列 */
    private final BlockingQueue<Runnable> workQueue;

    /** 工作线程 */
    private final List<Worker> workers = new ArrayList<>();

    public SimpleThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        // 创建线程
        for(int i = 0; i < poolSize; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            worker.start();
        }
    }

    /**
     * 提交任务
     * @param task
     */
    public void execute(Runnable task) {
        try {
            workQueue.put(task);
        } catch (InterruptedException e) {
            log.error("任务提交失败", e);
        }
    }

    private class Worker extends Thread {
        public void run() {
            // 循环获取任务，任务为空则一直阻塞
            while(true) {
                try {
                    Runnable task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    log.error("任务获取失败", e);
                }
            }
        }
    }
}
