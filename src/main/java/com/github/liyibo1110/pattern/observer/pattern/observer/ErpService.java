package com.github.liyibo1110.pattern.observer.pattern.observer;

/**
 * @author liyibo
 * @date 2025-10-23 18:23
 */
public class ErpService implements Observer {
    @Override
    public void update(String phone, String product) {
        System.out.println("用户(" + phone + ")购买的" + product + "发货了");
    }
}
