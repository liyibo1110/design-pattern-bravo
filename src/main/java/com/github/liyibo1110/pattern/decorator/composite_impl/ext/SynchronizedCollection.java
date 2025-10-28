package com.github.liyibo1110.pattern.decorator.composite_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.Collection;

/**
 * @author liyibo
 * @date 2025-10-27 15:00
 */
public class SynchronizedCollection<E> {

    /** 组合的实例 */
    private final Collection<E> collection;
    private final Object mutex;

    public SynchronizedCollection(Collection<E> collection) {
        this.collection = collection;
        this.mutex = this;
    }

    public SynchronizedCollection(Collection<E> collection, Object mutex) {
        this.collection = collection;
        this.mutex = mutex;
    }

    public int size() {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return this.collection.size();
        }
    }

    public E get(int index) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return this.collection.get(index);
        }
    }

    public void add(E e) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            this.collection.add(e);
        }
    }

    public boolean remove(Object o) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return this.collection.remove(o);
        }
    }
}
