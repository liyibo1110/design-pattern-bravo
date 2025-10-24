package com.github.liyibo1110.pattern.singleton.impl5;

import lombok.Getter;

/**
 * 懒汉式 + 双重同步方法 + volatile
 * @author liyibo
 * @date 2025-10-23 15:54
 */
@Getter
public class Person {

    private final String name;

    private Person(String name) {
        this.name = name;
    }

    private static volatile Person INSTANCE = null;

    public static Person getInstance() {
        if(INSTANCE == null)
            synchronized(Person.class) {
                if(INSTANCE == null)
                    INSTANCE = new Person("张三");
            }
        return INSTANCE;
    }
}
