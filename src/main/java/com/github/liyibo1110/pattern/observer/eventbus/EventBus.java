package com.github.liyibo1110.pattern.observer.eventbus;

import com.github.liyibo1110.pattern.observer.eventbus.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyibo
 * @date 2025-10-24 11:54
 */
public class EventBus {
    private final Map<Class<?>, List<EventListener<?>>> listeners = new HashMap<>();

    /**
     * 注册监听器
     * @param eventType
     * @param listener
     * @param <T>
     */
    public <T> void register(Class<T> eventType, EventListener<?> listener) {
        List<EventListener<?>> list = this.listeners.computeIfAbsent(eventType, k -> new ArrayList<>());
        list.add(listener);
    }

    /**
     * 移除监听器
     * @param eventType
     * @param listener
     * @param <T>
     */
    public <T> void unregister(Class<T> eventType, EventListener<?> listener) {
        List<EventListener<?>> list = this.listeners.get(eventType);
        if(list != null)
            list.remove(listener);
    }

    /**
     * 发布事件
     * @param event
     * @param <T>
     */
    public <T> void post(T event) {
        List<EventListener<?>> list = this.listeners.get(event.getClass());
        if(list != null) {
            for(EventListener l : list)
                l.onEvent(event);
        }
    }
}
