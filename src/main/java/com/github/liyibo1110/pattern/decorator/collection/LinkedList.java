package com.github.liyibo1110.pattern.decorator.collection;

/**
 * @author liyibo
 * @date 2025-10-27 14:40
 */
public class LinkedList<E> implements List<E> {
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void add(E e) {
        System.out.println("添加了1个元素：" + e);
        this.size++;
    }

    @Override
    public boolean remove(Object obj) {
        System.out.println("移除了1个元素：" + obj);
        this.size--;
        return true;
    }
}
