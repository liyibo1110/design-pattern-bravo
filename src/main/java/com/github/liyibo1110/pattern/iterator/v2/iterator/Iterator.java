package com.github.liyibo1110.pattern.iterator.v2.iterator;

/**
 * @author liyibo
 * @date 2025-10-24 14:30
 */
public interface Iterator<E> {
    /**
     * 有没有下个元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取下个元素
     * @return
     */
    E next();
}
