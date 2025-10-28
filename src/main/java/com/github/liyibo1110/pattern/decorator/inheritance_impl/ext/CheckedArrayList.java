package com.github.liyibo1110.pattern.decorator.inheritance_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.ArrayList;

/**
 * 通过继承，为原始ArrayList类增加了类型限定的功能，防止通过反射写入不一致的类型
 * @author liyibo
 * @date 2025-10-27 14:47
 */
public class CheckedArrayList<E> extends ArrayList<E> {
    private final Class<E> type;

    public CheckedArrayList(Class<E> type) {
        this.type = type;
    }

    @Override
    public void add(E e) {
        super.add(this.typeCheck(e));
    }

    private E typeCheck(Object obj) {
        System.out.println("typeCheck...");
        if(obj != null && !this.type.isInstance(obj))
            throw new ClassCastException("Attempt to insert " + obj.getClass() +
                    " element into collection with element type " + type);
        return (E)obj;
    }
}
