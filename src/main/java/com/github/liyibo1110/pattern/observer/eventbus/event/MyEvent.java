package com.github.liyibo1110.pattern.observer.eventbus.event;

import lombok.Getter;

/**
 * @author liyibo
 * @date 2025-10-24 11:52
 */
public class MyEvent {
    @Getter
    private final String message;

    public MyEvent(String message) {
        this.message = message;
    }
}
