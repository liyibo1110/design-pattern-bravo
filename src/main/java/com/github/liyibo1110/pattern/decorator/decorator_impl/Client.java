package com.github.liyibo1110.pattern.decorator.decorator_impl;

import com.github.liyibo1110.pattern.decorator.collection.ArrayList;
import com.github.liyibo1110.pattern.decorator.collection.List;
import com.github.liyibo1110.pattern.decorator.decorator_impl.ext.CheckedCollection;
import com.github.liyibo1110.pattern.decorator.decorator_impl.ext.SynchronizedCollection;
import com.github.liyibo1110.pattern.decorator.decorator_impl.ext.UnmodifiableCollection;

/**
 * 基于继承+组合实现的扩展（即装饰器模式），提供了叠加扩展的功能，还避免了单纯继承带来的弊端
 * @author liyibo
 * @date 2025-10-27 14:44
 */
public class Client {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");

        System.out.println("=======添加同步能力========");
        SynchronizedCollection<String> synchronizedList = new SynchronizedCollection<>(list);
        synchronizedList.add("李四");

        System.out.println("=======添加类型校验能力========");
        CheckedCollection<String> checkedList = new CheckedCollection<>(synchronizedList, String.class);
        checkedList.add("王五");

        System.out.println("=======添加不可变能力========");
        UnmodifiableCollection<String> unmodifiableList = new UnmodifiableCollection<>(checkedList);
        unmodifiableList.add("赵六"); // throw exception
    }
}
