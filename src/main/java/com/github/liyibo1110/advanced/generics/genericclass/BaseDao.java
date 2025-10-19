package com.github.liyibo1110.advanced.generics.genericclass;

/**
 * @author liyibo
 * @date 2025-10-17 10:49
 */
public class BaseDao<T> {

    public Long insert(T entity) {
        System.out.println("插入数据：" + entity);
        return null;
    }

    public T getById(Long id) {
        System.out.println("查询数据，id=" + id);
        return null;
    }
}
