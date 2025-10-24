package com.github.liyibo1110.pattern.iterator.v2.iterator;

/**
 * @author liyibo
 * @date 2025-10-24 14:30
 */
public interface Iterable<T> {
    /**
     * 获取迭代器
     * @return
     */
    Iterator<T> iterator();
}
