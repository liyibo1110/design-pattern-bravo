package com.github.liyibo1110.pattern.decorator.composite_impl;

import com.github.liyibo1110.pattern.decorator.collection.ArrayList;
import com.github.liyibo1110.pattern.decorator.decorator_impl.ext.SynchronizedCollection;

/**
 * 基于组合实现的扩展，缺点是取消了继承，也就没有了多态功能，只能提供单一功能的扩展，不能叠加扩展
 * @author liyibo
 * @date 2025-10-27 14:44
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        SynchronizedCollection<String> wrapperCollection = new SynchronizedCollection<>(list);
        wrapperCollection.add("张三");
        wrapperCollection.add("李四");
        System.out.println(wrapperCollection.size());
    }
}
