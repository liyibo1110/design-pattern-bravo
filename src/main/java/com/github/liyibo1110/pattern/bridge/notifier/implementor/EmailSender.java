package com.github.liyibo1110.pattern.bridge.notifier.implementor;

/**
 * @author liyibo
 * @date 2025-12-09 16:11
 */
public class EmailSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("发送邮件：" + message);
    }
}
