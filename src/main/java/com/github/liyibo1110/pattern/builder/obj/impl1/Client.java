package com.github.liyibo1110.pattern.builder.obj.impl1;

/**
 * @author liyibo
 * @date 2025-10-23 10:45
 */
public class Client {

    public static void main(String[] args) {
        Student s = new Student.Builder()
                .name("张三")
                .age(18)
                .address("北京市")
                .build();
        System.out.println(s);
    }
}
