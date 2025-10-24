package com.github.liyibo1110.pattern.singleton.impl2;

import lombok.Getter;

/**
 * 懒汉式
 * @author liyibo
 * @date 2025-10-23 15:52
 */
@Getter
public class Person {

    private final String name;

    private Person(String name) {
        this.name = name;
    }

    private static Person INSTANCE = null;

    public static Person getInstance() {
        if(INSTANCE == null)
            INSTANCE = new Person("张三");
        return INSTANCE;
    }
}
