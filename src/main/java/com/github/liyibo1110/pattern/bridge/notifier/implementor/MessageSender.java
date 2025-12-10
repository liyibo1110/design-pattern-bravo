package com.github.liyibo1110.pattern.bridge.notifier.implementor;

/**
 * 消息发送器（可以理解成某一个业务的“底层细节实现”，关注的是怎么做）
 * @author liyibo
 * @date 2025-12-09 16:06
 */
public interface MessageSender {
    void send(String message);
}
