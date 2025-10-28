package com.github.liyibo1110.pattern.decorator.collection;

/**
 * @author liyibo
 * @date 2025-10-27 14:37
 */
public interface Collection<E> {
    int size();
    E get(int index);
    void add(E e);
    boolean remove(Object obj);
}
