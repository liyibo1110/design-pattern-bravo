package com.github.liyibo1110.pattern.decorator.inheritance_impl;

import com.github.liyibo1110.pattern.decorator.inheritance_impl.ext.SynchronizedArrayList;

/**
 * 基于继承实现的扩展，缺点是不灵活，容易类爆炸
 * @author liyibo
 * @date 2025-10-27 14:43
 */
public class Client {
    public static void main(String[] args) {
        SynchronizedArrayList<Object> list = new SynchronizedArrayList<>();
        list.add("张三");
        list.add("李四");
        System.out.println(list.size());
    }
}
