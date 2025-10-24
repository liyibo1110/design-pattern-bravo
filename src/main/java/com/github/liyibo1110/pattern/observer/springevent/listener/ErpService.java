package com.github.liyibo1110.pattern.observer.springevent.listener;

import com.github.liyibo1110.pattern.observer.springevent.event.Event;
import com.github.liyibo1110.pattern.observer.springevent.event.OrderCompletedEvent;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 物流服务，监听下单事件，用户下单后发货
 * @author liyibo
 * @date 2025-10-24 11:39
 */
public class ErpService implements Listener<OrderCompletedEvent>  {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCompletedEvent event) {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("订单" + event.getSource() + "已经发货！");
    }

    @Override
    public boolean supportEventType(Event event) {
        return event instanceof OrderCompletedEvent;
    }
}
