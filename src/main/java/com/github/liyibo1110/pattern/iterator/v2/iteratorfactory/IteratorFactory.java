package com.github.liyibo1110.pattern.iterator.v2.iteratorfactory;

import com.github.liyibo1110.pattern.iterator.v2.container.Node;
import com.github.liyibo1110.pattern.iterator.v2.iterator.Iterator;

/**
 * 迭代器工厂，在这里被分离了出去
 * @author liyibo
 * @date 2025-10-24 14:54
 */
public interface IteratorFactory<E> {
    Iterator<E> createIterator(Node<E> root);
}
