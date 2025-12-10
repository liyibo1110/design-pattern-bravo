package com.github.liyibo1110.pattern.bridge.notifier.implementor;

/**
 * @author liyibo
 * @date 2025-12-09 16:11
 */
public class PushSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("推送APP：" + message);
    }
}
