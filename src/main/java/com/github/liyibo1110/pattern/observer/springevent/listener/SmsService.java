package com.github.liyibo1110.pattern.observer.springevent.listener;

import com.github.liyibo1110.pattern.observer.springevent.event.Event;
import com.github.liyibo1110.pattern.observer.springevent.event.OrderCompletedEvent;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 短信服务，监听下单事件，用户下单后发短信通知
 * @author liyibo
 * @date 2025-10-24 11:39
 */
public class SmsService implements Listener<OrderCompletedEvent>  {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCompletedEvent event) {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("下单成功！您的订单号是:" + event.getSource());
    }

    @Override
    public boolean supportEventType(Event event) {
        return event instanceof OrderCompletedEvent;
    }
}
