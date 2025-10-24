package com.github.liyibo1110.pattern.observer.pattern;

import com.github.liyibo1110.pattern.observer.pattern.observer.ErpService;
import com.github.liyibo1110.pattern.observer.pattern.observer.SmsService;

/**
 * @author liyibo
 * @date 2025-10-23 18:27
 */
public class OrderServiceClient {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.addObserver(new SmsService());
        orderService.addObserver(new ErpService());
        // 下单
        orderService.order("phone pro");
    }
}
