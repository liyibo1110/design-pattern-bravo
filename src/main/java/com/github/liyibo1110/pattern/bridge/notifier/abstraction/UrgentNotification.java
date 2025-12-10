package com.github.liyibo1110.pattern.bridge.notifier.abstraction;

import com.github.liyibo1110.pattern.bridge.notifier.implementor.MessageSender;

/**
 * @author liyibo
 * @date 2025-12-09 16:09
 */
public class UrgentNotification extends Notification {
    public UrgentNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notify(String message) {
        int retries = 3;
        while(retries > 0) {
            try {
                this.sender.send(message);
                break;
            } catch (Exception e) {
                retries--;  // 重试3次
            }
        }
    }
}
