package com.github.liyibo1110.pattern.strategy.impl1;

import java.util.Arrays;

/**
 * 自定义ArrayList，只能存储实现了Comparable接口的元素
 * @author liyibo
 * @date 2025-10-23 18:01
 */
public class ArrayList<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Object[] elementData;
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
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        return (E)this.elementData[index];
    }

    public void add(E element) {
        if(this.size >= 10)
            throw new RuntimeException("演示专用，最多存10个");
        this.elementData[this.size++] = element;
    }

    /** 排序相关逻辑 */
    public void sort() {
        for(int i = 0; i < this.size - 1; i++) {
            for(int j = 0; j < this.size - i - 1; j++) {
                if(this.get(j).compareTo(this.get(j + 1)) > 0)
                    this.swap(this.elementData, j, j + 1);
            }
        }
    }

    private void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.elementData);
    }
}
