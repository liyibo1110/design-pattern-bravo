package com.github.liyibo1110.pattern.builder.obj.impl2;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liyibo
 * @date 2025-10-23 11:03
 */
@Getter
@ToString
public class Student {
    private final String name;
    private final Integer age;
    private final String address;

    public static Builder builder() {
        return new Builder();
    }

    Student(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
