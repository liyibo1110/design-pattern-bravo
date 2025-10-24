package com.github.liyibo1110.pattern.observer.springevent.event;

import lombok.Getter;

/**
 * 观察者与被观察者之间的媒介
 * @author liyibo
 * @date 2025-10-24 11:21
 */
@Getter
public class Event {
    private final Object source;

    public Event(Object source) {
        this.source = source;
    }
}
