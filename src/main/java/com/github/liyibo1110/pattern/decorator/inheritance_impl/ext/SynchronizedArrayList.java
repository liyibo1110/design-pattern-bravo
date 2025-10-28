package com.github.liyibo1110.pattern.decorator.inheritance_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.ArrayList;

/**
 * 通过继承，为原始ArrayList类增加了线程安全的功能
 * @author liyibo
 * @date 2025-10-27 14:44
 */
public class SynchronizedArrayList<E> extends ArrayList<E> {
    /** 对象锁 */
    private final Object mutex;

    public SynchronizedArrayList() {
        this.mutex = this;
    }

    public SynchronizedArrayList(Object mutex) {
        this.mutex = mutex;
    }

    @Override
    public int size() {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return super.size();
        }
    }

    @Override
    public E get(int index) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return super.get(index);
        }
    }

    @Override
    public void add(E e) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            super.add(e);
        }
    }

    @Override
    public boolean remove(Object o) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return super.remove(o);
        }
    }
}
