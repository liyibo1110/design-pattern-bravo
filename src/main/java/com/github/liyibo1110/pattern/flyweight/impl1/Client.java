package com.github.liyibo1110.pattern.flyweight.impl1;

/**
 * @author liyibo
 * @date 2025-10-23 17:01
 */
public class Client {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(127);
        Integer b = Integer.valueOf(127);
        System.out.println(a == b); // true, 返回的是缓存池中同一对象

        Integer c = Integer.valueOf(128);
        Integer d = Integer.valueOf(128);
        System.out.println(c == d); // false, 不在缓存池中（-128~127），所以分别new了两个Integer
    }
}
