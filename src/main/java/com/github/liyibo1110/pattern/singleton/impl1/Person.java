package com.github.liyibo1110.pattern.singleton.impl1;

import lombok.Getter;

/**
 * 饿汉式（绝大部分情景这种就足够了，不需要考虑单例的初始化开销）
 * @author liyibo
 * @date 2025-10-23 15:48
 */
@Getter
public class Person {

    private final String name;

    private Person(String name) {
        this.name = name;
    }

    private static final Person INSTANCE = new Person("张三");

    public static Person getInstance() {
        return INSTANCE;
    }
}
