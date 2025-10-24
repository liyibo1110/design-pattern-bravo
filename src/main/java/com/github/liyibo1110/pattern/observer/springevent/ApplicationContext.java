package com.github.liyibo1110.pattern.observer.springevent;

import com.github.liyibo1110.pattern.observer.springevent.event.Event;
import com.github.liyibo1110.pattern.observer.springevent.listener.Listener;
import org.springframework.lang.Nullable;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * 事件通知机制的上下文控制核心
 * @author liyibo
 * @date 2025-10-24 11:32
 */
public class ApplicationContext {
    private final Set<Listener<?>> listeners = new LinkedHashSet<>();

    /** 支持异步事件的线程池 */
    private Executor taskExecutor;

    /**
     * 注册监听器
     * @param listener
     */
    public void registerListener(Listener<?> listener) {
        this.listeners.add(listener);
    }

    /**
     * 发布事件
     * @param e
     */
    public void publish(Event e) {
        Set<Listener<?>> matchedListeners = this.getMatchedListeners(e);
        for(var l : matchedListeners) {
            Executor executor = this.getTaskExecutor();
            if(executor == null)    // 同步模式
                this.invokeListener(l, e);
            else    // 异步模式
                executor.execute(() -> invokeListener(l, e));
        }
    }

    /**
     * 获取匹配要发送的listener
     * @param e
     * @return
     */
    private Set<Listener<?>> getMatchedListeners(Event e) {
        if(this.listeners.isEmpty())
            return Collections.emptySet();
        return this.listeners.stream()
                .filter(l -> l.supportEventType(e))
                .collect(Collectors.toSet());
    }

    private void invokeListener(Listener l, Event e) {
        l.onApplicationEvent(e);
    }

    public Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    public void setTaskExecutor(@Nullable Executor executor) {
        this.taskExecutor = executor;
    }
}
