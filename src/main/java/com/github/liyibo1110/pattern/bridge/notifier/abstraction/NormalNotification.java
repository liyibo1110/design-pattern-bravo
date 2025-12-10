package com.github.liyibo1110.pattern.bridge.notifier.abstraction;

import com.github.liyibo1110.pattern.bridge.notifier.implementor.MessageSender;

/**
 * @author liyibo
 * @date 2025-12-09 16:22
 */
public class NormalNotification extends Notification {
    public NormalNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notify(String message) {
        this.sender.send(message);
    }
}
