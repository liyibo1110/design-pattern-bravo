package com.github.liyibo1110.pattern.observer.eventbus;

import com.github.liyibo1110.pattern.observer.eventbus.event.MyEvent;
import com.github.liyibo1110.pattern.observer.eventbus.listener.MyEventListener;

/**
 * @author liyibo
 * @date 2025-10-24 12:01
 */
public class EventBusClient {
    public static void main(String[] args) {
        EventBus bus = new EventBus();
        // 注册监听器
        bus.register(MyEvent.class, new MyEventListener());
        // 发布事件
        MyEvent e = new MyEvent("Hello, EventBus!");
        bus.post(e);
    }
}
