package com.github.liyibo1110.pattern.bridge.notifier.abstraction;

import com.github.liyibo1110.pattern.bridge.notifier.implementor.MessageSender;

/**
 * 通知的业务规则（可以理解成高层逻辑，关注的是“做什么”，由其实现类来触发真正的干活动作）
 * @author liyibo
 * @date 2025-12-09 16:05
 */
public abstract class Notification {
    protected MessageSender sender;

    public Notification(MessageSender sender) {
        this.sender = sender;
    }

    public abstract void notify(String message);
}
