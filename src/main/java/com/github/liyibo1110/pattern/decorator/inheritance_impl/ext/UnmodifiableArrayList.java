package com.github.liyibo1110.pattern.decorator.inheritance_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.ArrayList;

/**
 * 通过继承，为原始ArrayList类增加了元素不可变的功能，即构造完成后，禁止添加或移除元素
 * @author liyibo
 * @date 2025-10-27 14:50
 */
public class UnmodifiableArrayList<E> extends ArrayList<E> {
    @Override
    public void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
}
