package com.github.liyibo1110.pattern.builder.obj.impl2;

/**
 * @author liyibo
 * @date 2025-10-23 11:05
 */
public class Client {

    public static void main(String[] args) {
        Student s = Student.builder()
                .name("张三")
                .age(18)
                .address("北京市")
                .build();
        System.out.println(s);
    }
}
