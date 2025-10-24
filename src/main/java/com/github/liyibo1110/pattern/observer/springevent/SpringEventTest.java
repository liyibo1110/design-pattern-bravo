package com.github.liyibo1110.pattern.observer.springevent;

import com.github.liyibo1110.pattern.observer.springevent.event.OrderCompletedEvent;
import com.github.liyibo1110.pattern.observer.springevent.listener.ErpService;
import com.github.liyibo1110.pattern.observer.springevent.listener.SmsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liyibo
 * @date 2025-10-24 11:43
 */
public class SpringEventTest {

    private final ApplicationContext context = new ApplicationContext();

    @BeforeEach
    public void refreshApplication() {
        this.context.registerListener(new SmsService());
        this.context.registerListener(new ErpService());
        this.context.setTaskExecutor(Executors.newFixedThreadPool(2));
    }

    @Test
    public void orderCompletedService() throws InterruptedException {
        // 这里扣减库存
        // 这里生成订单
        // 这里做其它后续
        // 下单成功，发布事件
        this.context.publish(new OrderCompletedEvent(10086L));
        // 等待异步消息
        TimeUnit.SECONDS.sleep(10);
    }
}
