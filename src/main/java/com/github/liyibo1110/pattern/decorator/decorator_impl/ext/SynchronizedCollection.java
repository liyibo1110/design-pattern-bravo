package com.github.liyibo1110.pattern.decorator.decorator_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.Collection;

/**
 * @author liyibo
 * @date 2025-10-27 15:21
 */
public class SynchronizedCollection<E> implements Collection<E> {
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

    @Override
    public int size() {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return this.collection.size();
        }
    }

    @Override
    public E get(int index) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return this.collection.get(index);
        }
    }

    @Override
    public void add(E e) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            this.collection.add(e);
        }
    }

    @Override
    public boolean remove(Object obj) {
        System.out.println("synchronized...");
        synchronized(this.mutex) {
            return this.collection.remove(obj);
        }
    }
}
