package com.github.liyibo1110.pattern.bridge.notifier.abstraction;

import com.github.liyibo1110.pattern.bridge.notifier.implementor.MessageSender;

/**
 * @author liyibo
 * @date 2025-12-09 16:10
 */
public class DelayedNotification extends Notification {
    private final long delayInSeconds;

    public DelayedNotification(MessageSender sender, long delayInSeconds) {
        super(sender);
        this.delayInSeconds = delayInSeconds;
    }

    @Override
    public void notify(String message) {
        new Thread(() -> {
            try {
                Thread.sleep((this.delayInSeconds * 1000));
                this.sender.send(message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        System.out.println("通知将在" + this.delayInSeconds + "秒后发送");
    }
}
