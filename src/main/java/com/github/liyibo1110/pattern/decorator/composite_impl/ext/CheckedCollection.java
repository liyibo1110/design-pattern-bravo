package com.github.liyibo1110.pattern.decorator.composite_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.Collection;

/**
 * @author liyibo
 * @date 2025-10-27 15:02
 */
public class CheckedCollection<E> {
    /** 组合的实例 */
    private final Collection<E> collection;
    private final Class<E> type;

    public CheckedCollection(Collection<E> collection, Class<E> type) {
        this.collection = collection;
        this.type = type;
    }

    public int size() {
        return this.collection.size();
    }

    public E get(int index) {
        return this.collection.get(index);
    }

    public void add(E e) {
        this.collection.add(this.typeCheck(e));
    }

    public boolean remove(Object o) {
        return this.collection.remove(o);
    }

    private E typeCheck(Object obj) {
        System.out.println("typeCheck...");
        if(obj != null && !this.type.isInstance(obj))
            throw new ClassCastException("Attempt to insert " + obj.getClass() +
                    " element into collection with element type " + type);
        return (E)obj;
    }
}
