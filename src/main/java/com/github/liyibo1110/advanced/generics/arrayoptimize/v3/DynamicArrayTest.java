package com.github.liyibo1110.advanced.generics.arrayoptimize.v3;

import java.util.Arrays;

/**
 * @author liyibo
 * @date 2025-10-17 10:38
 */
public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray<String> arr = new DynamicArray<>(3);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        System.out.println(arr);
        arr.add("d");
        System.out.println(arr);
    }

    static class DynamicArray<T> {
        private Object[] arr;
        private int size = 0;

        public DynamicArray(int initialCapacity) {
            this.arr = new Object[initialCapacity];
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            return (T)arr[index];
        }

        public void add(T str) {
            ensureCapacity(size + 1);
            arr[size++] = str;
        }

        private void ensureCapacity(int minCapacity) {
            if(minCapacity > arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
        }
    }
}
