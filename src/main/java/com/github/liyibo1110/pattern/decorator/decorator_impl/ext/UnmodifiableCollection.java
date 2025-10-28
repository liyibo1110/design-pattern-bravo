package com.github.liyibo1110.pattern.decorator.decorator_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.Collection;

/**
 * @author liyibo
 * @date 2025-10-27 15:28
 */
public class UnmodifiableCollection<E> implements Collection<E> {
    private final Collection<E> collection;

    public UnmodifiableCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public E get(int index) {
        return collection.get(index);
    }

    @Override
    public void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }
}
