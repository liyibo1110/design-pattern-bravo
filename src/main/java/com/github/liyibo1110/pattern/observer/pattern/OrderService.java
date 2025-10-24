package com.github.liyibo1110.pattern.observer.pattern;

import com.github.liyibo1110.pattern.observer.pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liyibo
 * @date 2025-10-23 18:25
 */
public class OrderService {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void order(String product) {
        // 模拟下单操作
        int orderNumber = ThreadLocalRandom.current().nextInt(1000);
        System.out.println("下单成功, 订单号:" + orderNumber);
        // 通知所有观察者
        this.notifyObservers(product);
    }

    private void notifyObservers(String product) {
        for(Observer observer : observers)
            observer.update("12345678901", product);
    }
}
