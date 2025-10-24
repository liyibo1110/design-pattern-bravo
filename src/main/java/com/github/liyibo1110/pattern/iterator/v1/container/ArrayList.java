package com.github.liyibo1110.pattern.iterator.v1.container;

import com.github.liyibo1110.pattern.iterator.v1.iterator.Iterable;
import com.github.liyibo1110.pattern.iterator.v1.iterator.Iterator;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 版本1：以内部类自行实现了迭代器的功能（优点是可以直接访问外部类的字段和方法，例如size或get）
 * @author liyibo
 * @date 2025-10-24 13:41
 */
public class ArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public ArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (E)this.elementData[index];
    }

    public void add(E e) {
        this.ensureCapacity(this.size + 1);
        this.elementData[this.size++] = e;
    }

    public boolean remove(Object obj) {
        for(int i = 0; i < this.size; i++) {
            // 先找待移除元素的下标
            if(obj.equals(this.elementData[i])) {
                int numMoved = this.size - i - 1;
                if(numMoved > 0) {
                    // 对于数组[begin...i...end]，把[i+1, end]的元素都往前移动一位
                    System.arraycopy(this.elementData, i + 1, this.elementData, i, numMoved);
                }
                // 上面移动完毕后，把数组末尾清空（因为元素都往前挪了）
                this.elementData[--this.size] = null;
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity(int minCapacity) {
        if(minCapacity > this.elementData.length) {
            // 新容量为旧容量的1.5倍
            int newCapacity = this.elementData.length + (this.elementData.length >> 1);
            this.elementData = Arrays.copyOf(this.elementData, newCapacity);
        }
    }

    /** 以下是迭代器相关实现 */

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return get(this.cursor++);
        }
    }
}
