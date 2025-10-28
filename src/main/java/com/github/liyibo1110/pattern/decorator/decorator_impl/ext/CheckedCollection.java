package com.github.liyibo1110.pattern.decorator.decorator_impl.ext;

import com.github.liyibo1110.pattern.decorator.collection.Collection;

/**
 * @author liyibo
 * @date 2025-10-27 15:24
 */
public class CheckedCollection<E> implements Collection<E> {
    private final Collection<E> collection;
    private final Class<E> type;

    public CheckedCollection(Collection<E> collection, Class<E> type) {
        this.collection = collection;
        this.type = type;
    }

    @Override
    public int size() {
        return this.collection.size();
    }

    @Override
    public E get(int index) {
        return this.collection.get(index);
    }

    @Override
    public void add(E e) {
        this.collection.add(this.typeCheck(e));
    }

    @Override
    public boolean remove(Object obj) {
        return this.collection.remove(obj);
    }

    private E typeCheck(Object obj) {
        System.out.println("typeCheck...");
        if(obj != null && !this.type.isInstance(obj))
            throw new ClassCastException("Attempt to insert " + obj.getClass() +
                    " element into collection with element type " + type);
        return (E)obj;
    }
}
