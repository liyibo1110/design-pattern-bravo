package com.github.liyibo1110.pattern.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * JDK自带的代理使用例子
 * @author liyibo
 * @date 2025-10-27 16:24
 */
public class Client {
    public static void main(String[] args) {
        // 目标对象
        CalculatorImpl targetObj = new CalculatorImpl();
        // 代理对象
        Calculator proxyCalculator = (Calculator)Proxy.newProxyInstance(
            Calculator.class.getClassLoader(),
            new Class[]{Calculator.class},
            (proxy, method, args1) -> {
                System.out.println("before " + method.getName());
                Object result = method.invoke(targetObj, args1);
                System.out.println("after " + method.getName());
                return result;
            }
        );
        System.out.println("执行结果：" + proxyCalculator.add(1, 2));
    }

    interface Calculator {
        int add(int a, int b);
    }

    static class CalculatorImpl implements Calculator {
        @Override
        public int add(int a, int b) {
            System.out.println("invoke add(a=" + a + " b=" + b + ")");
            return  a + b;
        }
    }
}
