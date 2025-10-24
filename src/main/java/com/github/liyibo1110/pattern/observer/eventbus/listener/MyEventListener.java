package com.github.liyibo1110.pattern.observer.eventbus.listener;

import com.github.liyibo1110.pattern.observer.eventbus.event.MyEvent;

/**
 * @author liyibo
 * @date 2025-10-24 11:54
 */
public class MyEventListener implements EventListener<MyEvent> {
    @Override
    public void onEvent(MyEvent event) {
        System.out.println("Processing event: " + event.getMessage());
    }
}
