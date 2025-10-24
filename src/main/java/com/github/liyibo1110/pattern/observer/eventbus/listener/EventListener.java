package com.github.liyibo1110.pattern.observer.eventbus.listener;

/**
 * @author liyibo
 * @date 2025-10-24 11:53
 */
public interface EventListener<T> {

    void onEvent(T event);
}
