package com.github.liyibo1110.pattern.observer.pattern.observer;

/**
 * @author liyibo
 * @date 2025-10-23 18:24
 */
public class SmsService implements Observer {
    @Override
    public void update(String phone, String product) {
        System.out.println("用户(" + phone + ")你购买了" + product);
    }
}
