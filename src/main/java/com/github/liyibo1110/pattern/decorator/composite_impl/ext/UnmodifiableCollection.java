package com.github.liyibo1110.pattern.decorator.composite_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.Collection;

/**
 * @author liyibo
 * @date 2025-10-27 15:04
 */
public class UnmodifiableCollection<E> {
    /** 组合的实例 */
    private final Collection<E> collection;

    public UnmodifiableCollection(Collection<E> collection) {
        this.collection = collection;
    }

    public int size() {
        return collection.size();
    }

    public E get(int index) {
        return collection.get(index);
    }

    public void add(E e) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
}
