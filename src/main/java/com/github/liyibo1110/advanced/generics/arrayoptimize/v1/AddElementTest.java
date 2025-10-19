package com.github.liyibo1110.advanced.generics.arrayoptimize.v1;

import java.util.Arrays;

/**
 * @author liyibo
 * @date 2025-10-17 10:16
 */
public class AddElementTest {

    public static void main(String[] args) {
        String[] arr = new String[3];
        addElement(arr, "a");
        addElement(arr, "b");
        addElement(arr, "c");
        addElement(arr, "d");
        System.out.println(Arrays.toString(arr));
    }

    public static void addElement(String[] arr, String ele) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                arr[i] = ele;
                break;
            }
        }
    }
}
