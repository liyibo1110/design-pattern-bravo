package com.github.liyibo1110.pattern.observer.springevent.listener;

import com.github.liyibo1110.pattern.observer.springevent.event.Event;

/**
 * 想要接收通知的组件，要实现这个Listener
 * @author liyibo
 * @date 2025-10-24 11:23
 */
public interface Listener<E extends Event> {

    /**
     * 事件发生时触发此回调
     * @param event
     */
    void onApplicationEvent(E event);

    /**
     * 是否可以处理这个事件
     * @param event
     * @return
     */
    boolean supportEventType(Event event);
}
