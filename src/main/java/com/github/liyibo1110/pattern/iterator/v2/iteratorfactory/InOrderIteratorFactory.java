package com.github.liyibo1110.pattern.iterator.v2.iteratorfactory;

import com.github.liyibo1110.pattern.iterator.v2.container.Node;
import com.github.liyibo1110.pattern.iterator.v2.iterator.InOrderIterator;
import com.github.liyibo1110.pattern.iterator.v2.iterator.Iterator;

/**
 * @author liyibo
 * @date 2025-10-24 14:55
 */
public class InOrderIteratorFactory<E extends Comparable<E>> implements IteratorFactory<E> {
    @Override
    public Iterator<E> createIterator(Node<E> root) {
        return new InOrderIterator<>(root);
    }
}
