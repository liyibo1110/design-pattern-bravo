package com.github.liyibo1110.pattern.bridge.notifier;

import com.github.liyibo1110.pattern.bridge.notifier.abstraction.DelayedNotification;
import com.github.liyibo1110.pattern.bridge.notifier.abstraction.NormalNotification;
import com.github.liyibo1110.pattern.bridge.notifier.abstraction.UrgentNotification;
import com.github.liyibo1110.pattern.bridge.notifier.implementor.EmailSender;
import com.github.liyibo1110.pattern.bridge.notifier.implementor.PushSender;
import com.github.liyibo1110.pattern.bridge.notifier.implementor.SmsSender;

/**
 * @author liyibo
 * @date 2025-12-09 15:51
 */
public class Test {
    public static void main(String[] args) {
        // 发送方式
        EmailSender emailSender = new EmailSender();
        SmsSender smsSender = new SmsSender();
        PushSender pushSender = new PushSender();

        // 组合1：紧急 + 短信
        UrgentNotification urgentSms = new UrgentNotification(smsSender);
        urgentSms.notify("快起来，服务器挂啦！！！");

        // 组合2：普通 + 邮件
        NormalNotification normalEmail = new NormalNotification(emailSender);
        normalEmail.notify("这只是一条普通的邮件消息，不用紧张");

        // 组合3：紧急 + APP推送
        UrgentNotification urgentPush = new UrgentNotification(pushSender);
        urgentPush.notify("这是一条紧急版本的推送消息，快点查看！");

        // 组合4：延迟 + 短信
        DelayedNotification delayedSms = new DelayedNotification(smsSender, 3);
        delayedSms.notify("这是一条延迟版本的短信");
    }
}
