package com.github.liyibo1110.advanced.generics.arrayoptimize.v2;

import java.util.Arrays;

/**
 * @author liyibo
 * @date 2025-10-17 10:23
 */
public class DynamicStringArrayTest {

    static class DynamicStringArray {
        private String[] arr;
        private int size = 0;

        public DynamicStringArray(int initialCapacity) {
            this.arr = new String[initialCapacity];
        }

        public String get(int index) {
            return arr[index];
        }

        public void add(String str) {
            ensureCapacity(size + 1);
            arr[size++] = str;  // 会先执行赋值，再执行size++
        }

        private void ensureCapacity(int minCapacity) {
            if(minCapacity > arr.length) {
                // double capacity
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
        }
    }
}
