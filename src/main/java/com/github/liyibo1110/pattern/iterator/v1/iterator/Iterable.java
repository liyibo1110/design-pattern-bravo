package com.github.liyibo1110.pattern.iterator.v1.iterator;

/**
 * @author liyibo
 * @date 2025-10-24 13:41
 */
public interface Iterable<T> {
    /**
     * 获取迭代器
     * @return
     */
    Iterator<T> iterator();
}
